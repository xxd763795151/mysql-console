package com.xuxd.mysql.console.bean;

import java.io.Serializable;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 09:50
 * @Description: mysql源连接信息
 */
public class SourceInfo implements Serializable {


    private static final long serialVersionUID = 5795139455025170738L;
    String ip;
    int port;
    String pass;
    String name;

    public SourceInfo() {
    }

    public SourceInfo(String ip, int port, String pass, String name) {
        this.ip = ip;
        this.port = port;
        this.pass = pass;
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SourceInfo{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
