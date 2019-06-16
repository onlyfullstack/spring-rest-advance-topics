package com.onlyfullstack.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("test")
@Service
public class TestConfigServer implements ConfigServer {

	@Override
	public String setup() {
		return "Calling Test Config Server";
	}
}
