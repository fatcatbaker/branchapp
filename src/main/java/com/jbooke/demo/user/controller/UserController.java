package com.jbooke.demo.user.controller;


import com.jbooke.demo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/user", produces = {MediaType.APPLICATION_JSON_VALUE, "application/json"})
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<?> getUserDetails(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok(userService.getGitHubUserDetails(username));
    }
}
