package com.kevin.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

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
	public String home() throws ParseException {
//		AllType allType = new AllType();
//		allType.setTinyint_s(1);
//		allType.setSmallint_s(2);
//		allType.setMediumint_s(3);
//		allType.setInt_s(4);
//		allType.setInteger_s(5);
//		allType.setBigint_s(6);
//		allType.setBit_s(true);
//		allType.setReal_s(7.07d);
//		allType.setDouble_s(8.08d);
//		allType.setFloat_s(9.09f);
//		allType.setDecimal_s(new BigDecimal(10.10));
//		allType.setNumeric_s(new BigDecimal(11.11));
//		allType.setChar_s("char_s");
//		allType.setVarchar_s("varchar_s");
//		allType.setDate_s("2017-12-12");
//		allType.setTime_s("15:27:32");
//		allType.setYear_s("2018");
////		allType.setTimestamp_s(new Date());
//		allType.setDatetime(new Date());
//		allType.setTinyblob_s("tinyblob");
//		allType.setBlob_s("blob_s");
//		allType.setMediumblob_s("mediumblob");
//		allType.setLongblob_s("longblob");
//		allType.setTinytext_s("tinytext");
//		allType.setText_s("text_s");
//		allType.setMediumtext_s("mediumtext");
//		allType.setLongtext_s("longtext");
//		allType.setEnum_s("one");
//		allType.setSet_s("a,b,c");
//		allType.setBinary_s("binary");
//		allType.setVarbinary_s("varbinary");
//		allTypeMapper.save(allType);
		
		//查询操作
//		AllType allType = new AllType();
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		allType.setId(10);
//		allType.setDatetime(format.parse("2018-03-22 16:07:10"));
//		List<AllType> temps = allTypeMapper.find(allType);
//		AllType temp = temps.get(0);
//		System.out.println(temp.getDate_s());
//		System.out.println(temp.getTime_s());
//		System.out.println(temp.getYear_s());
//		System.out.println(format.format(temp.getTimestamp_s()));
//		System.out.println(format.format(temp.getDatetime()));
		
		//更新操作
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tinyint_s", 2);
		allTypeMapper.update(11, map, AllType.class);
		
		//删除操作
//		allTypeMapper.delete(10, AllType.class);
		
		return "success";
	}
	
}
