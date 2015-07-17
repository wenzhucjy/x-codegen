package com.github.wenzhu.xgen.config.vo;

import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

public class ModuleConfModel {

	/**
	 * 用户需要生成的模块的标识
	 */
	private String id = "";
	/**
	 * 用户需要生成这个模块所使用的外部主题的标识
	 */
	private String theme = "";
	/**
	 * 用户需要生成的具体功能，key-需要生成的功能的标识，value-该功能生成后的多种输出类型的标识的集会
	 */
	private Map<String,List<String>> needGendTypes = newHashMap();
	/**
	 * 模块生成所需要的扩展数据，key-数据的id，value-对应的扩展数据的model
	 */
	private Map<String, ExtendConfModel> extendsMap = newHashMap();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Map<String, List<String>> getNeedGendTypes() {
		return needGendTypes;
	}

	public void setNeedGendTypes(Map<String, List<String>> needGendTypes) {
		this.needGendTypes = needGendTypes;
	}

	public Map<String, ExtendConfModel> getExtendsMap() {
		return extendsMap;
	}

	public void setExtendsMap(Map<String, ExtendConfModel> extendsMap) {
		this.extendsMap = extendsMap;
	}

}
