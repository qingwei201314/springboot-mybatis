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
	public boolean home() {
		City argCity = new City();
		argCity.setName("kevin1");
		argCity.setState("2");
		argCity.setDes("desc");
		boolean result = cityMapper.save(argCity);
		return result;
	}
}
