package com.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kevin.dto.City;
import com.kevin.mapper.common.CommonMapper;

@Mapper
public interface CityMapper extends CommonMapper<City>{
	@Select("SELECT * FROM city WHERE state = #{state}")
    City findByState(@Param("state") String state);
	
	City selectCity(@Param("id") Integer id);
}
