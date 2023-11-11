package com.jbooke.demo.integration.github.model;

import lombok.Data;

@Data
public class GithubUserRepositoryOwner {
	private String gistsUrl;
	private String reposUrl;
	private String followingUrl;
	private String starredUrl;
	private String login;
	private String followersUrl;
	private String type;
	private String url;
	private String subscriptionsUrl;
	private String receivedEventsUrl;
	private String avatarUrl;
	private String eventsUrl;
	private String htmlUrl;
	private Boolean siteAdmin;
	private Integer id;
	private String gravatarId;
	private String nodeId;
	private String organizationsUrl;
}