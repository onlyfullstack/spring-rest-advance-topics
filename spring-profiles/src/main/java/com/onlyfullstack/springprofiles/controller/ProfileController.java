package com.onlyfullstack.springprofiles.controller;

import com.onlyfullstack.springprofiles.model.FinalResponse;
import com.onlyfullstack.springprofiles.model.MailSettings;
import com.onlyfullstack.springprofiles.service.ConfigServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    ConfigServer configServer;

    @Autowired
    MailSettings mailSettings;

    @GetMapping("/welcome")
    public FinalResponse getDataBaseConnectionDetails() {
        return new FinalResponse(configServer.setup(), mailSettings);
    }
}
