package com.xuxd.mysql.console.controller;

import com.xuxd.mysql.console.bean.SourceInfo;
import com.xuxd.mysql.console.common.OutObject;
import com.xuxd.mysql.console.service.ISourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 许晓东
 * @Date: 18-7-17 16:34
 * @Description: 数据源管理
 */
@RestController
@RequestMapping("/dbsource")
public class DBSourceManageController {

    @Autowired
    private ISourceManager sourceManager;

    @PostMapping("/save/info")
    public OutObject saveSourceInfo(SourceInfo sourceInfo) throws Exception {
        return sourceManager.save(sourceInfo);
    }

}
