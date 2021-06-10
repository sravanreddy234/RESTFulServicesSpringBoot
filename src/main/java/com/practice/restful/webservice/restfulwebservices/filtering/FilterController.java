package com.practice.restful.webservice.restfulwebservices.filtering;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {		
		return new SomeBean(12,"new","pass");
	}
	
	
	/*@GetMapping("/filtering-list")
	public List<SomeBean> retrieveSomeBeanList() {		
		return Arrays.asList(new SomeBean(12,"new1","pass1"),new SomeBean(13,"new1","pass1"));
	}*/

}
