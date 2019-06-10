package com.onlyfullstack.springprofiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${onlyfullstack.message}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String getDataBaseConnectionDetails() {
        return welcomeMessage;
    }
}
