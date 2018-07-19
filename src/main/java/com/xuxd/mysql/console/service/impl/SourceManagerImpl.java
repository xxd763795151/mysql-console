package com.xuxd.mysql.console.service.impl;

import com.xuxd.mysql.console.bean.SourceInfo;
import com.xuxd.mysql.console.service.ISourceManager;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 09:47
 * @Description:
 */
@Service("sourceManager")
public class SourceManagerImpl implements ISourceManager {
    @Autowired(required = false)
    CacheManager cacheManager;

    @Override
    @Cacheable("sourceCache")
    public void save(SourceInfo info) throws Exception {
        Cache cache = cacheManager.getCache("sourceCache");
    }
}
