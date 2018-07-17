package com.xuxd.mysql.console.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 许晓东
 * @Date: 18-7-17 16:34
 * @Description: 数据源管理
 */
@RestController
@RequestMapping("/dbsource")
public class DBSourceManageController {


    @PostMapping("/save/info")
    public String saveDbConnectionInfo(HttpServletRequest request) {
        return "hello";
    }

}
