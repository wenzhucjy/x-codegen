package com.github.wenzhu.xgen.config;

import com.github.wenzhu.xgen.config.implementors.GenImplementor;

public class GenConfigFactory {

	private GenConfigFactory() {}
	
	public GenConfigEbi createGenConfigEbi(GenImplementor provider) {
		return GenConfigEbo.getInstance(provider);
	}
}
