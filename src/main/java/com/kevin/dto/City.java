package com.kevin.dto;

import java.io.Serializable;

import com.kevin.annotation.Column;
import com.kevin.annotation.Ignore;
import com.kevin.annotation.Table;

@Table(name = "city")
public class City implements Serializable{
	private static final long serialVersionUID = -1719223572259294496L;
	
	private Integer id;
	@Column(name = "name")
	private String name;
	private String ename;
	private String code;
	private String state;
	@Ignore
	private String des;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
}
