package com.kevin.controller;

import java.lang.reflect.Field;

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
		City city = cityMapper.testProvider(argCity);
		return city;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		City city = new City();
		city.setId(new Integer(3));
		Field[] fields = city.getClass().getDeclaredFields();
		Field field = fields[1];
		field.setAccessible(true);
		Object o = field.get(city);
		System.out.println(o);
	}
}
