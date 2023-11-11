package com.jbooke.demo.integration.github.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GithubUserRepository{
	private Boolean allowForking;
	private Integer stargazersCount;
	private Boolean isTemplate;
	private LocalDateTime pushedAt;
	private String language;
	private String subscriptionUrl;
	private String branchesUrl;
	private String issueCommentUrl;
	private String labelsUrl;
	private String subscribersUrl;
	private String releasesUrl;
	private String svnUrl;
	private Integer id;
	private String fullName;
	private Boolean hasDiscussions;
	private Integer forks;
	private String archiveUrl;
	private String gitRefsUrl;
	private String forksUrl;
	private String visibility;
	private String statusesUrl;
	private String sshUrl;
	private Integer size;
	private String languagesUrl;
	private String htmlUrl;
	private String collaboratorsUrl;
	private String cloneUrl;
	private String name;
	private String url;
}