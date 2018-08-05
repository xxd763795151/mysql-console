package com.xuxd.mysql.console.config;

import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;

import java.util.Properties;

/**
 * @Auther: 许晓东
 * @Date: 18-8-5 18:48
 * @Description:
 */
public class SourceCacheBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory {
    @Override
    public BootstrapCacheLoader createBootstrapCacheLoader(Properties properties) {
        return new SourceCacheBootstrapLoader();
    }
}
