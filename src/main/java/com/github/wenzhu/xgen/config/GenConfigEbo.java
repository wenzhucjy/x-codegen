package com.github.wenzhu.xgen.config;

import java.util.Map;

import com.github.wenzhu.xgen.config.implementors.GenImplementor;
import com.github.wenzhu.xgen.config.manager.ConfigManager;
import com.github.wenzhu.xgen.config.vo.GenConfigModel;
import com.github.wenzhu.xgen.config.vo.ModuleConfModel;

public class GenConfigEbo implements GenConfigEbi {
	
	private static GenConfigEbo ebo = null;
	
	private GenImplementor provider = null;
	
	private GenConfigEbo(GenImplementor provider) {
		this.provider = provider;
	}
	
	public static GenConfigEbi getInstance(GenImplementor provider) {
		if(ebo == null) {
			if(provider == null) {
				throw new IllegalArgumentException("��һ�δ������ö���ʱ��provider����Ϊ��");
			}
			ebo = new GenConfigEbo(provider);
		}
		return ebo;
	}
	

	@Override
	public GenConfigModel getConfig() {
		return ConfigManager.getInstance(provider).getGenConfig();
	}

	@Override
	public Map<String, ModuleConfModel> getMapModuleConf() {
		return ConfigManager.getInstance(provider).getMapModuleConfig();
	}

}
