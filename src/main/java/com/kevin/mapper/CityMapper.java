package com.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kevin.dto.City;
import com.kevin.mapper.common.CommonMapper;

@Mapper
public interface CityMapper extends CommonMapper<City> {
	City findByState(@Param("state") String state);

}
