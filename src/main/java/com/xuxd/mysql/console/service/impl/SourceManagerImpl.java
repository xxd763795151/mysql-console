package com.xuxd.mysql.console.service.impl;

import com.xuxd.mysql.console.bean.SourceInfo;
import com.xuxd.mysql.console.common.OutObject;
import com.xuxd.mysql.console.excepton.ConsoleException;
import com.xuxd.mysql.console.excepton.OperationFail;
import com.xuxd.mysql.console.service.ISourceManager;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 09:47
 * @Description:
 */
@Service("sourceManager")
public class SourceManagerImpl implements ISourceManager {

    @Resource(name = "sourceCache")
    Cache sourceCache;

    @Override
    public OutObject save(SourceInfo info) throws Exception {
        Element element = new Element(info.getName(), info);
        Element result = sourceCache.putIfAbsent(element);
        if (result != null) {
            throw new OperationFail("保存失败，cause:可能该名称已存在");
        }
        sourceCache.flush();
        return OutObject.success("保存成功");
    }
}
