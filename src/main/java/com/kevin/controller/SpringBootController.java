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
		// conflict 222
        // conflict 333
		// 我增加了stash 222
        // 我增加了stash 333
		String name = "北京市";
		City city = cityMapper.find(name);
		return city;

	}
	
}
