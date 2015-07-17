package com.github.wenzhu.xgen.config.vo;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import com.google.common.base.MoreObjects;
/**
 * 名称: ThemeModel.java<br>
 * 描述: 读取ThemeConf.xml文件,转换为样式对象<br>
 * 类型: JAVA<br>
 * @since  2015年7月17日
 * @author jy.chen
 */
public class ThemeModel {

	private String id;
	private String location;
	private Map<String, GenTypeModel> genTypeMap = newHashMap();
	private Map<String, String> genOutTypeMap = newHashMap();
	private Map<String, String> providerMap = newHashMap();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, GenTypeModel> getGenTypeMap() {
		return genTypeMap;
	}

	public void setGenTypeMap(Map<String, GenTypeModel> genTypeMap) {
		this.genTypeMap = genTypeMap;
	}

	public Map<String, String> getGenOutTypeMap() {
		return genOutTypeMap;
	}

	public void setGenOutTypeMap(Map<String, String> genOutTypeMap) {
		this.genOutTypeMap = genOutTypeMap;
	}

	public Map<String, String> getProviderMap() {
		return providerMap;
	}

	public void setProviderMap(Map<String, String> providerMap) {
		this.providerMap = providerMap;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper("ThemeModel").omitNullValues()
				.add("id", this.id)
				.add("location", this.location)
				.add("genTypeMap", this.genTypeMap)
				.add("genOutTypeMap", this.genOutTypeMap)
				.add("providerMap", this.providerMap)
				.toString();
	}
	
	
}
