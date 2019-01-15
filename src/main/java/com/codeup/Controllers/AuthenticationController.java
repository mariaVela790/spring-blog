package com.codeup.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "users/login";
    }
}
