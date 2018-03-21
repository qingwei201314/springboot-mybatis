package com.kevin.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.dto.AllType;
import com.kevin.mapper.AllTypeMapper;

@RestController
public class SpringBootController {
	@Resource
	private AllTypeMapper allTypeMapper;

	@RequestMapping("/")
	public String home() {
		AllType allType = new AllType();
		allType.setTinyint_s(1);
		allType.setSmallint_s(2);
		allType.setMediumint_s(3);
		allType.setInt_s(4);
		allType.setInteger_s(5);
		allType.setBigint_s(6);
		allType.setBit_s(true);
		allType.setReal_s(7.07d);
		allType.setDouble_s(8.08d);
		allType.setFloat_s(9.09f);
		allType.setDecimal_s(new BigDecimal(10.10));
		allType.setNumeric_s(new BigDecimal(11.11));
		allType.setChar_s("char_s");
		allType.setVarchar_s("varchar_s");
		allType.setDate_s(new Date());
		allType.setTime_s(new Date());
		allType.setYear_s(new Date());
		allType.setTimestamp_s(new Date());
		allType.setDatetime(new Date());
		allType.setTinyblob_s("tinyblob");
		allType.setBlob_s("blob_s");
		allType.setMediumblob_s("mediumblob");
		allType.setLongblob_s("longblob");
		allType.setTinytext_s("tinytext");
		allType.setText_s("text_s");
		allType.setMediumtext_s("mediumtext");
		allType.setLongtext_s("longtext");
		allType.setEnum_s("one");
		allType.setSet_s("a,b,c");
		allType.setBinary_s("binary");
		allType.setVarbinary_s("varbinary");
		
		allTypeMapper.save(allType);
		return "success";
	}
}
