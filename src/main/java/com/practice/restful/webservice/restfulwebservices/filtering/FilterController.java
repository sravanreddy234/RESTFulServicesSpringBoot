package com.practice.restful.webservice.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	/* for static filtering  */
	/*@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {		
		return new SomeBean(12,"new","pass");
	}
	
	 for static filtering  
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveSomeBeanList() {
		SomeBean bean1 = new SomeBean(12,"new1","pass1");
		SomeBean bean2 = new SomeBean(13,"new2","pass2");

		return Arrays.asList(bean1,bean2);
		
		return Arrays.asList(new SomeBean(12,"new1","pass1"),new SomeBean(13,"new2","pass2"));
	}*/
	
	
	/* for dynamic filtering  */
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {	
		
		SomeBean someBean = new SomeBean(12,"new","pass");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","password");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	/* for dynamic filtering  */
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveSomeBeanList() {

		List<SomeBean> list = Arrays.asList(new SomeBean(12,"new1","pass1"),new SomeBean(13,"new2","pass2"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","password");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
