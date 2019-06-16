package com.onlyfullstack.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class ProdConfigServer implements ConfigServer {

	@Override
	public String setup() {
		return "Calling Prod Config Server";
	}
}
