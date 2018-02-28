package com.kevin.dto;

import java.io.Serializable;

public class City implements Serializable{
	private static final long serialVersionUID = -7116359891979693149L;
	
	private Integer id;
	private String name;
	private String state;
	private String des;
	
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
