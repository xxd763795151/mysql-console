package com.xuxd.mysql.console.config;

import com.xuxd.mysql.console.common.Constants;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 许晓东
 * @Date: 18-8-5 18:40
 * @Description:
 */
public class SourceCacheBootstrapLoader implements BootstrapCacheLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(SourceCacheBootstrapLoader.class);

    @Override
    public void load(Ehcache cache) throws CacheException {
        LOGGER.info("开始加载缓存备份");
        File file = new File(Constants.BAK_PATH);
        try {
            if (!file.exists()) {
                LOGGER.warn("没有发现缓存备份，路径{}", Constants.BAK_PATH);
                return;
            }
            String data = FileUtils.readFileToString(file);
            JSONObject jsonObject = JSONObject.fromObject(data);
            Collection<JSONObject> objects = jsonObject.values();
            Set<Element> elements = new HashSet<>();
            for (JSONObject o :
                    objects) {
                //elements.add((Element) JSONObject.toBean(o, Element.class));
                elements.add(convert2Element(o));
            }
            cache.putAll(elements);
            LOGGER.info("缓存备份加载结束，共{}条数据", cache.getSize());
        } catch (IOException e) {
            LOGGER.error("加载备份错误，", e);
        }

    }

    @Override
    public boolean isAsynchronous() {
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    private Element convert2Element(JSONObject jsonObject) {
        Element element = new Element("", "");
        Set<String> keys = jsonObject.keySet();
        for (String key :
                keys) {
            try {
                Field field = element.getClass().getDeclaredField(key);
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.getType() == Object.class)
                    field.set(element, jsonObject.getString(key));
                else
                    field.set(element, jsonObject.get(key));
                field.setAccessible(isAccessible);
            } catch (Exception ignore) {
            }
        }
        return element;
    }
}
