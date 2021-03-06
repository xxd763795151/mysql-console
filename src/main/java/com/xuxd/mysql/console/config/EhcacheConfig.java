package com.xuxd.mysql.console.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 10:08
 * @Description: ehcache配置，因为有自己的业务场景，不直接使用spring-cache，虽然spring-cache更方便
 */
@Configuration
public class EhcacheConfig {

    private static final CacheManager CACHE_MANAGER = CacheManager.create();

    @Bean("sourceCache")
    public Cache sourceCache() {
        return CACHE_MANAGER.getCache("sourceCache");
    }

    @Bean("connectionCache")
    public Cache connectionCache() {
        return CACHE_MANAGER.getCache("connectionCache");
    }

}
