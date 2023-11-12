package com.jbooke.demo.user.service;

import com.jbooke.demo.integration.github.exceptions.ResourceNotFoundException;
import com.jbooke.demo.integration.github.model.GithubUser;
import com.jbooke.demo.integration.github.model.GithubUserRepository;
import com.jbooke.demo.integration.github.service.GithubUserService;
import com.jbooke.demo.mapper.UserMapper;
import com.jbooke.demo.mapper.UserRepositoryMapper;
import com.jbooke.demo.user.model.User;
import com.jbooke.demo.user.model.UserGithubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final GithubUserService githubUserService;
    private final UserMapper userMapper;
    private final UserRepositoryMapper userRepositoryMapper;

    @Autowired
    public UserService(GithubUserService githubUserService,
                       UserMapper userMapper,
                       UserRepositoryMapper userRepositoryMapper) {
        this.githubUserService = githubUserService;
        this.userMapper = userMapper;
        this.userRepositoryMapper = userRepositoryMapper;
    }
    @Cacheable("userCache")
    public User getGitHubUserDetails(String username) {
        Assert.notNull(username, "Username cannot be null");

        Optional<GithubUser> githubUserOptional = getGithubUser(username);
        //This has been added for safety.  A 404 is thrown from Github if the user is not found.
        //But, if the API changes and returns a 200 with an empty body this will prevent an NPE.
        GithubUser githubUser = githubUserOptional.orElseThrow(() -> new ResourceNotFoundException("Github user not found"));

        List<GithubUserRepository> githubUserRepositories = getGithubUserRepositories(username);

        User user = userMapper.githubUserToUser(githubUser);
        List<UserGithubRepository> userRepositories = githubUserRepositories.stream().map(userRepositoryMapper::githubUserRepositoryToUserRepository).toList();

        user.setRepositories(userRepositories);

        return user;
    }

    private Optional<GithubUser> getGithubUser(String username) {
        return githubUserService.getGithubUserByUsername(username);
    }

    private List<GithubUserRepository> getGithubUserRepositories(String username) {
        return githubUserService.getGithubUserRepositoriesByUsername(username);
    }
}
