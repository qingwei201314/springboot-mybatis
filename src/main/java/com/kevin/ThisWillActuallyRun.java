package com.kevin;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.dto.City;
import com.kevin.mapper.CityMapper;

@RestController
public class ThisWillActuallyRun {
	@Resource
	private CityMapper cityMapper;

	@RequestMapping("/")
	public City home() {
		City city = cityMapper.selectCity(3);
		return city;
	}
	
	@RequestMapping("/string")
	public String string() {
		City city = cityMapper.findByState("CA");
		return JSONObject.toJSONString(city);
	}

}
