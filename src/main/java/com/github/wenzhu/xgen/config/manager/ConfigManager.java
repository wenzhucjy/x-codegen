package com.github.wenzhu.xgen.config.manager;

import java.util.HashMap;
import java.util.Map;

import com.github.wenzhu.xgen.config.implementors.GenImplementor;
import com.github.wenzhu.xgen.config.implementors.ModuleGenImplementor;
import com.github.wenzhu.xgen.config.vo.GenConfigModel;
import com.github.wenzhu.xgen.config.vo.ModuleConfModel;
import com.github.wenzhu.xgen.config.vo.NeedGenModel;

public class ConfigManager {
	
	private static ConfigManager manager = null;
	
	private ConfigManager(GenImplementor provider) {
		readConfig(provider);
	}
	
	public static ConfigManager getInstance(GenImplementor provider) {
		if(manager == null) {
			manager = new ConfigManager(provider);
		}
		return manager;
	}
	
	//ʵ����ݻ���
	private GenConfigModel genConf = new GenConfigModel();
	private Map<String, ModuleConfModel> moduleConf = new HashMap<>();

	public GenConfigModel getGenConfig() {
		return this.genConf;
	}
	
	public Map<String, ModuleConfModel> getMapModuleConfig() {
		return this.moduleConf;
	}
	
	/**
	 * ȥ�����ʵ����ݵĶ�ȡ
	 */
	private void readConfig(GenImplementor provider) {
		//��ȡ���������ļ�
		readGenConfig(provider);
		for(NeedGenModel model : genConf.getNeedGens()) {
			readOneModelConfig(model);
		}
	}

	private void readGenConfig(GenImplementor provider) {
		genConf.setNeedGens(provider.getNeedGens());
		genConf.setThemes(provider.getThemes());
		genConf.setMapConstants(provider.getMapConstants());
	}
	
	private void readOneModelConfig(NeedGenModel model) {
		ModuleConfModel conf = new ModuleConfModel();
		
		String themeId = model.getTheme();
		String providerClassName = genConf.getThemeById(themeId).getProvider().get(model.getProvider());
		ModuleGenImplementor userGenConfImpl = null;
		try {
			userGenConfImpl = (ModuleGenImplementor) Class.forName(providerClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		conf = userGenConfImpl.getBaseModuleConfModel(model.getParams());
		conf.setTheme(themeId);
		conf.setNeedGendTypes(userGenConfImpl.getMapNeedGenTypes(model.getParams()));
		conf.setExtendsMap(userGenConfImpl.getMapExtends(genConf, model.getParams()));
		
		//��ģ�������������õ�������
		this.moduleConf.put(conf.getId(), conf);
	}
	
}
