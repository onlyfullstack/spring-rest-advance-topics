package com.onlyfullstack.springprofiles.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("onlyfullstack.mail")
public class MailSettings {

    private String server;
    private String username;
    private String password;
    private String customSetting;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomSetting() {
        return customSetting;
    }

    public void setCustomSetting(String customSetting) {
        this.customSetting = customSetting;
    }

    @Override
    public String toString() {
        return "MailSettings{" +
                "server='" + server + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", customSetting='" + customSetting + '\'' +
                '}';
    }
}