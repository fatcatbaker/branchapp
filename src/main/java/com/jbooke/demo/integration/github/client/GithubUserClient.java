package com.jbooke.demo.integration.github.client;

import com.jbooke.demo.integration.github.config.GithubClientConfiguration;
import com.jbooke.demo.integration.github.model.GithubUser;
import com.jbooke.demo.integration.github.model.GithubUserRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "gitHubUserClient", url = "${github.root-url}/users", configuration = GithubClientConfiguration.class)
public interface GithubUserClient {
    @GetMapping(value = "/{username}")
    GithubUser getUserByUsername(@PathVariable(value = "username") String username);
    @GetMapping(value = "/{username}/repos")
    List<GithubUserRepository> getUserRepositoriesByUsername(@PathVariable(value = "username") String username);
}
