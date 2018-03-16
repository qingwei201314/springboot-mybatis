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
	public City home() {
		City argCity = new City();
		argCity.setId(2);
		City city = cityMapper.find(argCity);
		return city;
	}
	
}
