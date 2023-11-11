package com.jbooke.demo.mapper;

import com.jbooke.demo.integration.github.model.GithubUserRepository;
import com.jbooke.demo.user.model.UserGithubRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRepositoryMapper {
    UserGithubRepository githubUserRepositoryToUserRepository(GithubUserRepository githubUserRepository);
}
