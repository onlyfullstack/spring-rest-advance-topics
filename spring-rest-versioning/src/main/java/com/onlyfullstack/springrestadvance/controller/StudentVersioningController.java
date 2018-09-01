package com.onlyfullstack.springrestadvance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlyfullstack.springrestadvance.datatransferobject.StudentV1;
import com.onlyfullstack.springrestadvance.datatransferobject.StudentV2;

@RestController
public class StudentVersioningController {

	@GetMapping(value = "/students" , produces="application/onlyfullstack.app-v1+json")
	public StudentV1 studentV1WithContentType() {
		return new StudentV1("Saurabh Oza");
	}

	@GetMapping(value = "/students" , produces="application/onlyfullstack.app-v2+json")
	public StudentV2 studentV2WithContentType() {
		return new StudentV2("Saurabh", "Oza");
	}
	
	@GetMapping(value = "/students" , headers="version=1")
	public StudentV1 studentV1WithHeader() {
		return new StudentV1("Saurabh Oza");
	}

	@GetMapping(value = "/students" , headers="version=2")
	public StudentV2 studentV2WithHeader() {
		return new StudentV2("Saurabh", "Oza");
	}
	
	@GetMapping(value = "/students" , params="version=1")
	public StudentV1 studentV1WithQueryParam() {
		return new StudentV1("Saurabh Oza");
	}

	@GetMapping(value = "/students" , params="version=2")
	public StudentV2 studentV2WithQueryParam() {
		return new StudentV2("Saurabh", "Oza");
	}
	
	@GetMapping("/v1/students")
	public StudentV1 studentV1() {
		return new StudentV1("Saurabh Oza");
	}

	@GetMapping("/v2/students")
	public StudentV2 studentV2() {
		return new StudentV2("Saurabh", "Oza");
	}
}
