package com.jbooke.demo.mapper;

import com.jbooke.demo.integration.github.model.GithubUser;
import com.jbooke.demo.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userName", source = "login")
    @Mapping(target = "displayName", source = "name")
    @Mapping(target = "avatar", source = "avatarUrl")
    @Mapping(target = "geoLocation", source = "location")
    User githubUserToUser(GithubUser githubUser);

}
