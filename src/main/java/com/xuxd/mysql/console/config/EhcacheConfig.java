package com.xuxd.mysql.console.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Properties;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 10:08
 * @Description: ehcache配置，因为有自己的业务场景，不直接使用spring-cache，虽然spring-cache更方便
 */
@Configuration
public class EhcacheConfig {

    @Bean("cacheManager")
    public CacheManager cacheManager() {
        final CacheManager cacheManager = CacheManager.create();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                cacheManager.shutdown();
            }
        }));
        return cacheManager;
    }

    @Bean("sourceCache")
    @DependsOn("cacheManager")
    public Cache sourceCache() {
        return cacheManager().getCache("sourceCache");
    }

    @Bean("connectionCache")
    @DependsOn("cacheManager")
    public Cache connectionCache() {
        return cacheManager().getCache("connectionCache");
    }

}
