package com.xuxd.mysql.console.common;

import java.io.File;

/**
 * Created by dong on 2018/7/26.
 */
public class Constants {

    public static final String SUCCESS_CODE = "0";
    public static final String ERROR_CODE = "-9999";
    public static final String BAK_PATH = getBakPath();


    public static String getBakPath() {
        StringBuilder bakPath = new StringBuilder(System.getProperty("user.dir"));
        bakPath.append(File.separator).append("cache").append(File.separator).append("source.json");
        return bakPath.toString();
    }
}
