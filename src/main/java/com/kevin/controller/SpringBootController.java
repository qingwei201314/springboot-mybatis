package com.kevin.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.dto.City;
import com.kevin.mapper.CityMapper;

@RestController
public class SpringBootController {
	@Resource
	private CityMapper cityMapper;

	@RequestMapping("/")
	public String home() {
		City city = new City();
		city.setId(3468);
		city.setName("1");
		city.setState("2");
		city.setCode("3");
		city.setEname("4");
		city = cityMapper.update(city);
		return "success";
	}
}
