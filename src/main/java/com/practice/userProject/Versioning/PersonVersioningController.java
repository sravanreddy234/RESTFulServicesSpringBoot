package com.practice.userProject.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		
		return new PersonV1("firstName LastName");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		
		return new PersonV2(new Name("firstName","lastName"));
	}
	
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 paramV1() {
		
		return new PersonV1("firstName LastName");
	}
	
	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 paramV2() {
		
		return new PersonV2(new Name("firstName","lastName"));
	}
	
	@GetMapping(value = "person/headers", headers = "X-API-VERSION=1")
	public PersonV1 headersV1() {
		
		return new PersonV1("firstName LastName");
	}
	
	@GetMapping(value = "person/headers", headers = "X-API-VERSION=2")
	public PersonV2 headersV2() {
		
		return new PersonV2(new Name("firstName","lastName"));
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		
		return new PersonV1("firstName LastName");
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		
		return new PersonV2(new Name("firstName","lastName"));
	}
}
