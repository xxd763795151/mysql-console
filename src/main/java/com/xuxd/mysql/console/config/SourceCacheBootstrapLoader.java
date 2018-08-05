package com.xuxd.mysql.console.config;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;

/**
 * @Auther: 许晓东
 * @Date: 18-8-5 18:40
 * @Description:
 */
public class SourceCacheBootstrapLoader implements BootstrapCacheLoader {
    @Override
    public void load(Ehcache cache) throws CacheException {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
    }

    @Override
    public boolean isAsynchronous() {
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }
}
