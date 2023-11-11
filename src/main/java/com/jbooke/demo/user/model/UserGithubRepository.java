package com.jbooke.demo.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGithubRepository implements Serializable {

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private String name;
    private String url;
}
