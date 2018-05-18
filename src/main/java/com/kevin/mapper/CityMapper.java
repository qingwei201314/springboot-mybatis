package com.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.kevin.dto.City;
import com.kevin.mapper.common.CommonMapper;
import com.kevin.mapper.common.CommonProvider;

@Mapper
public interface CityMapper extends CommonMapper<City> {
	
	@SelectProvider(type = CommonProvider.class, method = "find")
	City find(String name);
}
