package com.github.wenzhu.xgen.config.manager;

import java.util.HashMap;
import java.util.Map;

import com.github.wenzhu.xgen.config.vo.GenConfModel;
import com.github.wenzhu.xgen.config.vo.ModuleConfModel;
import com.github.wenzhu.xgen.config.vo.NeedGenModel;
import com.github.wenzhu.xgen.genconf.implementors.GenConfImplementor;
import com.github.wenzhu.xgen.genconf.implementors.ModuleGenConfImplementor;
/**
 * 
 * 名称: ConfManager.java<br>
 * 描述:负责真正去获取配置数据，并缓存配置数据 <br>
 * 类型: JAVA<br>
 * @since  2015年7月17日
 * @author jy.chen
 */
public class ConfManager {
	
	private static ConfManager manager = null;
	
	private ConfManager(GenConfImplementor provider) {
		readConfig(provider);
	}
	
	public static ConfManager getInstance(GenConfImplementor provider) {
		if(manager == null) {
			manager = new ConfManager(provider);
		}
		return manager;
	}
	// 定义需要缓存的数据
	private GenConfModel genConf = new GenConfModel();
	private Map<String, ModuleConfModel> moduleConf = new HashMap<>();

	public GenConfModel getGenConfig() {
		return this.genConf;
	}
	
	public Map<String, ModuleConfModel> getMapModuleConfig() {
		return this.moduleConf;
	}
	private void readConfig(GenConfImplementor provider) {
		//真正的获取配置数据
		readGenConfig(provider);
		for(NeedGenModel model : genConf.getNeedGens()) {
			readOneModelConfig(model);
		}
	}

	private void readGenConfig(GenConfImplementor provider) {
		genConf.setNeedGens(provider.getNeedGens());
		genConf.setThemes(provider.getThemes());
		genConf.setMapConstants(provider.getMapConstants());
	}
	
	private void readOneModelConfig(NeedGenModel model) {
		ModuleConfModel conf = new ModuleConfModel();
		
		String themeId = model.getTheme();
		String providerClassName = genConf.getThemeById(themeId).getProviderMap().get(model.getProvider());
		ModuleGenConfImplementor userGenConfImpl = null;
		try {
			userGenConfImpl = (ModuleGenConfImplementor) Class.forName(providerClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		conf = userGenConfImpl.getBaseModuleConfModel(model.getParams());
		conf.setTheme(themeId);
		conf.setNeedGendTypes(userGenConfImpl.getMapNeedGenTypes(model.getParams()));
		conf.setExtendsMap(userGenConfImpl.getMapExtends(genConf, model.getParams()));
		
		this.moduleConf.put(conf.getId(), conf);
	}
	
}
