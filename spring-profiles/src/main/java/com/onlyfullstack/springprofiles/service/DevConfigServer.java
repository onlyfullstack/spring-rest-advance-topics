package com.onlyfullstack.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class DevConfigServer implements ConfigServer {

	@Override
	public String setup() {
		return "Calling Dev Config Server";
	}
}
