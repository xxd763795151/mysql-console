package com.xuxd.mysql.console.service;

import com.xuxd.mysql.console.bean.SourceInfo;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 09:46
 * @Description: 属性源管理
 */
public interface ISourceManager {

    public void save(SourceInfo info) throws Exception;
}
