package com.wizeline.maven.learningjavamaven.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wizeline.maven.learningjavamaven.model.ResponseDTO;
import com.wizeline.maven.learningjavamaven.service.UserService;



@Component
public class CommonServices {

    @Autowired
    private UserService userService;

    public ResponseDTO login(String user, String password) {
        return userService.login(user, password);
    }

}
