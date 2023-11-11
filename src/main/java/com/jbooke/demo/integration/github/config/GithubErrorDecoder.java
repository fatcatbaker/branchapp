package com.jbooke.demo.integration.github.config;

import com.jbooke.demo.integration.github.exceptions.BadRequestException;
import com.jbooke.demo.integration.github.exceptions.InternalServerException;
import com.jbooke.demo.integration.github.exceptions.ResourceNotFoundException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Slf4j
public class GithubErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        switch(response.status()) {
            case 400:
                log.error("Bad request: {}", response);
                return new BadRequestException("Bad Request");
            case 404:
                log.error("Resource not found: {}", response);
                return new ResourceNotFoundException("Github User Not Found");
            case 429:
                log.error("Rate limit exceeded: {}", response);

                Map<String, Collection<String>> errorHeaders = response.headers();
                Collection<String> headerValues = errorHeaders.get("retry-after");

                Long retryAfter = 0L;

                if (!CollectionUtils.isEmpty(headerValues)) {
                    retryAfter = Long.parseLong(errorHeaders.get("retry-after").iterator().next());
                    return new RetryableException(response.status(), methodKey, null, new Date(System.currentTimeMillis() + retryAfter), response.request());
                }
            case 500:
                log.error("Internal server error: {}", response);
                return new InternalServerException("Internal Server Error");
            default:
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}
