package com.github.wenzhu.xgen.genconf.implementors;

import java.util.Map;

import com.github.wenzhu.xgen.config.vo.GenTypeModel;

/**
 * 名称: ThemeImplementer.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 * @since  2015年7月17日
 * @author jy.chen
 */
public interface ThemeImplementor {
	/**
	 * 根据theme Id 和在核心框架里面注册theme时配置的相应的参数，来获取theme中定义的能生成的功能类型
	 * @param themeId theme Id 
	 * @param params 在核心框架里面注册theme时配置的相应的参数
	 * @return theme中定义的能生成的功能类型
	 */
	public Map<String,GenTypeModel> getMapGenTypes(String themeId,Map<String,String> params);
	
	/**
	 * 根据theme Id 和在核心框架里面注册theme时配置的相应的参数，来获取theme中定义的能生成的外部功能类型
	 * @param themeId
	 * @param params
	 * @return
	 */
	public Map<String,String> getMapGenOutTypes(String themeId,Map<String,String> params);
	
	public Map<String,String> getMapProviders(String themeId,Map<String,String> params);
}
