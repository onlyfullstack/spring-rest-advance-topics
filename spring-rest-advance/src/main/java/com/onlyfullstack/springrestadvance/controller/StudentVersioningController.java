package com.onlyfullstack.springrestadvance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlyfullstack.springrestadvance.datatransferobject.StudentV1;
import com.onlyfullstack.springrestadvance.datatransferobject.StudentV2;

@RestController
@RequestMapping(value="/students")
public class StudentVersioningController {

	
	@GetMapping("v1")
	  public StudentV1 studentV1() {
	    return new StudentV1("Bob Charlie");
	  }

	  @GetMapping("v2/student")
	  public StudentV2 studentV2() {
	    return new StudentV2("Bob", "Charlie");
	  }

}
