package com.kevin.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kevin.annotation.Table;

@Table(name = "all_type")
public class AllType implements Serializable {
	private static final long serialVersionUID = -8000347463474568211L;
	private Integer id;
	private Integer tinyint_s;
	private Integer smallint_s;
	private Integer mediumint_s;
	private Integer int_s;
	private Integer integer_s;
	private Integer bigint_s;
	private Boolean bit_s;
	private Double real_s;
	private Double double_s;
	private Float float_s;
	private BigDecimal decimal_s;
	private BigDecimal numeric_s;
	private String char_s;
	private String varchar_s;
	private String date_s;
	private String time_s;
	private String year_s;
	private Date timestamp_s;
	private Date datetime;
	private String tinyblob_s;
	private String blob_s;
	private String mediumblob_s;
	private String longblob_s;
	private String tinytext_s;
	private String text_s;
	private String mediumtext_s;
	private String longtext_s;
	private String enum_s;
	private String set_s;
	private String binary_s;
	private String varbinary_s;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTinyint_s() {
		return tinyint_s;
	}

	public void setTinyint_s(Integer tinyint_s) {
		this.tinyint_s = tinyint_s;
	}

	public Integer getSmallint_s() {
		return smallint_s;
	}

	public void setSmallint_s(Integer smallint_s) {
		this.smallint_s = smallint_s;
	}

	public Integer getMediumint_s() {
		return mediumint_s;
	}

	public void setMediumint_s(Integer mediumint_s) {
		this.mediumint_s = mediumint_s;
	}

	public Integer getInt_s() {
		return int_s;
	}

	public void setInt_s(Integer int_s) {
		this.int_s = int_s;
	}

	public Integer getInteger_s() {
		return integer_s;
	}

	public void setInteger_s(Integer integer_s) {
		this.integer_s = integer_s;
	}

	public Integer getBigint_s() {
		return bigint_s;
	}

	public void setBigint_s(Integer bigint_s) {
		this.bigint_s = bigint_s;
	}

	public Boolean getBit_s() {
		return bit_s;
	}

	public void setBit_s(Boolean bit_s) {
		this.bit_s = bit_s;
	}

	public Double getReal_s() {
		return real_s;
	}

	public void setReal_s(Double real_s) {
		this.real_s = real_s;
	}

	public Double getDouble_s() {
		return double_s;
	}

	public void setDouble_s(Double double_s) {
		this.double_s = double_s;
	}

	public Float getFloat_s() {
		return float_s;
	}

	public void setFloat_s(Float float_s) {
		this.float_s = float_s;
	}

	public BigDecimal getDecimal_s() {
		return decimal_s;
	}

	public void setDecimal_s(BigDecimal decimal_s) {
		this.decimal_s = decimal_s;
	}

	public BigDecimal getNumeric_s() {
		return numeric_s;
	}

	public void setNumeric_s(BigDecimal numeric_s) {
		this.numeric_s = numeric_s;
	}

	public String getChar_s() {
		return char_s;
	}

	public void setChar_s(String char_s) {
		this.char_s = char_s;
	}

	public String getVarchar_s() {
		return varchar_s;
	}

	public void setVarchar_s(String varchar_s) {
		this.varchar_s = varchar_s;
	}

	public String getDate_s() {
		return date_s;
	}

	public void setDate_s(String date_s) {
		this.date_s = date_s;
	}

	public String getTime_s() {
		return time_s;
	}

	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}

	public String getYear_s() {
		return year_s;
	}

	public void setYear_s(String year_s) {
		this.year_s = year_s;
	}

	public Date getTimestamp_s() {
		return timestamp_s;
	}

	public void setTimestamp_s(Date timestamp_s) {
		this.timestamp_s = timestamp_s;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getTinyblob_s() {
		return tinyblob_s;
	}

	public void setTinyblob_s(String tinyblob_s) {
		this.tinyblob_s = tinyblob_s;
	}

	public String getBlob_s() {
		return blob_s;
	}

	public void setBlob_s(String blob_s) {
		this.blob_s = blob_s;
	}

	public String getMediumblob_s() {
		return mediumblob_s;
	}

	public void setMediumblob_s(String mediumblob_s) {
		this.mediumblob_s = mediumblob_s;
	}

	public String getLongblob_s() {
		return longblob_s;
	}

	public void setLongblob_s(String longblob_s) {
		this.longblob_s = longblob_s;
	}

	public String getTinytext_s() {
		return tinytext_s;
	}

	public void setTinytext_s(String tinytext_s) {
		this.tinytext_s = tinytext_s;
	}

	public String getText_s() {
		return text_s;
	}

	public void setText_s(String text_s) {
		this.text_s = text_s;
	}

	public String getMediumtext_s() {
		return mediumtext_s;
	}

	public void setMediumtext_s(String mediumtext_s) {
		this.mediumtext_s = mediumtext_s;
	}

	public String getLongtext_s() {
		return longtext_s;
	}

	public void setLongtext_s(String longtext_s) {
		this.longtext_s = longtext_s;
	}

	public String getEnum_s() {
		return enum_s;
	}

	public void setEnum_s(String enum_s) {
		this.enum_s = enum_s;
	}

	public String getSet_s() {
		return set_s;
	}

	public void setSet_s(String set_s) {
		this.set_s = set_s;
	}

	public String getBinary_s() {
		return binary_s;
	}

	public void setBinary_s(String binary_s) {
		this.binary_s = binary_s;
	}

	public String getVarbinary_s() {
		return varbinary_s;
	}

	public void setVarbinary_s(String varbinary_s) {
		this.varbinary_s = varbinary_s;
	}
}
