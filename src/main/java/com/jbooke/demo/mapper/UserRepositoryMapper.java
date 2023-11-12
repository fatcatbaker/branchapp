package com.jbooke.demo.mapper;

import com.jbooke.demo.integration.github.model.GithubUserRepository;
import com.jbooke.demo.user.model.UserGithubRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRepositoryMapper {
    @Mapping(target = "url", source = "svnUrl")
    UserGithubRepository githubUserRepositoryToUserRepository(GithubUserRepository githubUserRepository);
}
