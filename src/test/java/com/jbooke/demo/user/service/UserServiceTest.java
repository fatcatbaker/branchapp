package com.jbooke.demo.user.service;

import com.jbooke.demo.integration.github.exceptions.ResourceNotFoundException;
import com.jbooke.demo.integration.github.model.GithubUser;
import com.jbooke.demo.integration.github.model.GithubUserRepository;
import com.jbooke.demo.integration.github.service.GithubUserService;
import com.jbooke.demo.mapper.UserMapper;
import com.jbooke.demo.mapper.UserRepositoryMapper;
import com.jbooke.demo.user.model.User;
import com.jbooke.demo.user.model.UserGithubRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private GithubUserService mockGithubUserService;
    @Mock
    private UserMapper mockUserMapper;
    @Mock
    private UserRepositoryMapper mockUserRepositoryMapper;

    private UserService userServiceUnderTest;

    @BeforeEach
    void setUp() {
        userServiceUnderTest = new UserService(mockGithubUserService, mockUserMapper, mockUserRepositoryMapper);
    }

    @Test
    void testGetGitHubUserDetailsSuccess() {
        // Setup
        final GithubUser githubUser = new GithubUser();
        final String username = "octocat";
        final String displayName = "The Octocat";
        final String location = "San Francisco";
        final String avatarUrl = "https://avatars.githubusercontent.com/u/583231?v=4";
        final String htmlUrl = "https://api.github.com/users/octocat";
        final String createDateTimeString = "2011-01-25T18:44:36Z";
        final String repositoryName = "boysenberry-repo-1";
        final String repositoryUrl = "https://github.com/octocat/boysenberry-repo-1";
        final LocalDateTime createDateTime = LocalDateTime.parse(createDateTimeString, DateTimeFormatter.ISO_DATE_TIME);

        githubUser.setLogin(username);
        githubUser.setName(displayName);
        githubUser.setEmail(null);
        githubUser.setLocation(location);
        githubUser.setAvatarUrl(avatarUrl);
        githubUser.setCreatedAt(createDateTime);
        githubUser.setHtmlUrl(htmlUrl);
        when(mockGithubUserService.getGithubUserByUsername(username)).thenReturn(Optional.of(githubUser));

        // Configure GithubUserService.getGithubUserRepositoriesByUsername(...).
        final List<GithubUserRepository> githubUserRepositories = List.of(new GithubUserRepository(repositoryName, repositoryUrl));
        when(mockGithubUserService.getGithubUserRepositoriesByUsername(username)).thenReturn(githubUserRepositories);

        // Configure UserMapper.githubUserToUser(...).
        final User user = new User();
        user.setUserName(username);
        user.setDisplayName(displayName);
        user.setAvatar(avatarUrl);
        user.setGeoLocation(location);
        user.setCreatedAt(createDateTime);

        final UserGithubRepository userGithubRepository = new UserGithubRepository();
        user.setRepositories(List.of(userGithubRepository));

        when(mockUserMapper.githubUserToUser(any(GithubUser.class))).thenReturn(user);
        when(mockUserRepositoryMapper.githubUserRepositoryToUserRepository(any(GithubUserRepository.class)))
                .thenReturn(new UserGithubRepository(repositoryName, repositoryUrl));

        // Run the test
        final User result = userServiceUnderTest.getGitHubUserDetails(username);

        // Verify the results
        assertEquals(username, result.getUserName());
        assertEquals(displayName, result.getDisplayName());
        assertEquals(avatarUrl, result.getAvatar());
        assertEquals(location, result.getGeoLocation());
        assertEquals(createDateTime, result.getCreatedAt());
        assertNull(result.getEmail());
        assertEquals(1, result.getRepositories().size());
        assertEquals(repositoryName, result.getRepositories().get(0).getName());
    }

    @Test
    void testGetGitHubUserDetailsGithubUserIsEmpty() {
        // Setup
        // Configure GithubUserService.getGithubUserByUsername(...).
        final Optional<GithubUser> githubUser = Optional.empty();
        final String username = "user-that-is-empty";
        when(mockGithubUserService.getGithubUserByUsername(username)).thenReturn(githubUser);

        assertThrows(ResourceNotFoundException.class, () -> userServiceUnderTest.getGitHubUserDetails(username));
    }
}
