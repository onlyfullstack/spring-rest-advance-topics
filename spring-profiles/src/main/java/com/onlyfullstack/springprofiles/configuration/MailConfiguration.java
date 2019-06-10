package com.onlyfullstack.springprofiles.configuration;

import com.onlyfullstack.springprofiles.model.MailSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MailConfiguration {

    @Autowired
    MailSettings mailSettings;

    @Profile("dev")
    @Bean
    public String devMailServer() {
        System.out.println("Mail Server to Development - High Performance Instance");
        mailSettings.setCustomSetting("Dev Mail Server");
        System.out.println(mailSettings);
        return "Dev Mail server";
    }

    @Profile("test")
    @Bean
    public String testMailServer() {
        System.out.println("Mail Server to Test - High Performance Instance");
        mailSettings.setCustomSetting("Test Mail Server");
        System.out.println(mailSettings);
        return "Test Mail server";
    }

    @Profile("prod")
    @Bean
    public String productionMailServer() {
        System.out.println("Mail Server to Production - High Performance Instance");
        mailSettings.setCustomSetting("Production Mail Server");
        System.out.println(mailSettings);
        return "Production Mail server";
    }
}
