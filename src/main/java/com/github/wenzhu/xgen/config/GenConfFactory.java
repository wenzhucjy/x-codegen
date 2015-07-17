package com.github.wenzhu.xgen.config;

import com.github.wenzhu.xgen.genconf.implementors.GenConfImplementor;

public class GenConfFactory {

	private GenConfFactory() {}
	/**
	 * 创建访问核心配置的接口对象,前提是确保已经获取了配置数据,这个方法才能正确执行
	 * @return
	 */
	public GenConfEbi createGenConfigEbi(GenConfImplementor provider) {
		return GenConfEbo.getInstance(provider);
	}
}
