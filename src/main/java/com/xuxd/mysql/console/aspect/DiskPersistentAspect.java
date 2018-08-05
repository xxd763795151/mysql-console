package com.xuxd.mysql.console.aspect;

import com.xuxd.mysql.console.common.Constants;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 许晓东
 * @Date: 18-8-5 16:35
 * @Description:
 */
@Aspect
@Component
public class DiskPersistentAspect {


    @Resource(name = "sourceCache")
    private Cache sourceCache;

    @Pointcut("@annotation(com.xuxd.mysql.console.annotation.DiskPersistent)")
    public void point() {

    }


    @After("point()")
    public void after(JoinPoint joinPoint) throws Throwable {
        save2Disk();
    }

    private void save2Disk() throws IOException {
        List<String> keys = sourceCache.getKeys();
        Map<Object, Element> map = sourceCache.getAll(keys);
        JSONObject json = JSONObject.fromObject(map);
        File file = new File(Constants.BAK_PATH);
        FileUtils.forceDeleteOnExit(file);
        FileUtils.touch(file);
        Writer writer = new FileWriter(file);
        json.write(writer);
        writer.close();
    }
}
