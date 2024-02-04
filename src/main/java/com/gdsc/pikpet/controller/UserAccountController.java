package com.gdsc.pikpet.controller;


import com.gdsc.pikpet.config.security.UserSecurityDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserAccountController {

    @GetMapping("")
    public UserSecurityDto userInfo(Authentication authentication) {
        UserSecurityDto userSecurityDto = (UserSecurityDto) authentication.getPrincipal();
        return userSecurityDto;
    }
}
