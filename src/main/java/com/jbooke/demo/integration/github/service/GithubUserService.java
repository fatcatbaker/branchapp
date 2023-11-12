package com.jbooke.demo.integration.github.service;

import com.jbooke.demo.integration.github.client.GithubUserClient;
import com.jbooke.demo.integration.github.model.GithubUser;
import com.jbooke.demo.integration.github.model.GithubUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class GithubUserService {
    private final GithubUserClient githubUserClient;

    @Autowired
    public GithubUserService(GithubUserClient githubUserClient) {
        this.githubUserClient = githubUserClient;
    }

    public GithubUser getGithubUserByUsername(String username) {
        return githubUserClient.getUserByUsername(username);
    }

    public List<GithubUserRepository> getGithubUserRepositoriesByUsername(String username) {
        List<GithubUserRepository> githubUserRepositories = githubUserClient.getUserRepositoriesByUsername(username);

        return CollectionUtils.isEmpty(githubUserRepositories) ? Collections.emptyList() : githubUserRepositories;
    }
}
