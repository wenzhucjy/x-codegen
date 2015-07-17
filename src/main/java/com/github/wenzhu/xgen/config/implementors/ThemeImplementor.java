package com.github.wenzhu.xgen.config.implementors;

import java.util.Map;

import com.github.wenzhu.xgen.config.vo.GenTypeModel;

public interface ThemeImplementor {

	public Map<String,GenTypeModel> getMapGenTypes(String themeId,Map<String,String> params);
	
	public Map<String,String> getMapGenOutTypes(String themeId,Map<String,String> params);
	
	public Map<String,String> getMapProviders(String themeId,Map<String,String> params);
	
}
