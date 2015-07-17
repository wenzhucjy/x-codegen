package com.github.wenzhu.xgen.config;

import java.util.Map;

import com.github.wenzhu.xgen.config.manager.ConfManager;
import com.github.wenzhu.xgen.config.vo.GenConfModel;
import com.github.wenzhu.xgen.config.vo.ModuleConfModel;
import com.github.wenzhu.xgen.genconf.implementors.GenConfImplementor;
/**
 * 名称: GenConfigEbo.java<br>
 * 描述: 负责完成配置管理模块的业务功能<br>
 * 类型: JAVA<br>
 * @since  2015年7月17日
 * @author jy.chen
 */
public class GenConfEbo implements GenConfEbi {
	
	private static GenConfEbo ebo = null;
	/**
	 * 持有 获取核心框架配置数据的 具体实现接口对象
	 */
	private GenConfImplementor provider = null;
	
	private GenConfEbo(GenConfImplementor provider) {
		this.provider = provider;
	}
	
	public static GenConfEbi getInstance(GenConfImplementor provider) {
		if(ebo == null) {
			if(provider == null) {
				throw new IllegalArgumentException("第一次创建配置对象时，provider不能为空");
			}
			ebo = new GenConfEbo(provider);
		}
		return ebo;
	}
	

	@Override
	public GenConfModel getConfig() {
		return ConfManager.getInstance(provider).getGenConfig();
	}

	@Override
	public Map<String, ModuleConfModel> getMapModuleConf() {
		return ConfManager.getInstance(provider).getMapModuleConfig();
	}

}
