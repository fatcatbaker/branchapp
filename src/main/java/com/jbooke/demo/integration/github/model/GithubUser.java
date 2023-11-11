package com.jbooke.demo.integration.github.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GithubUser {
	private String login;
	private Integer id;
	private String name;
	private String email;
	private String twitterUsername;
	private Integer following;
	private String bio;
	private String location;
	private String nodeId;
	private String type;
	private String blog;
	private Integer followers;
	private String company;
	private String hireable;
	private Boolean siteAdmin;
	private Integer publicRepos;
	private String gravatarId;
	private Integer publicGists;

	private String url;
	private String organizationsUrl;
	private String receivedEventsUrl;
	private String followingUrl;
	private String subscriptionsUrl;
	private String avatarUrl;
	private String eventsUrl;
	private String htmlUrl;
	private String starredUrl;
	private String followersUrl;
	private String gistsUrl;
	private String reposUrl;

	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
}