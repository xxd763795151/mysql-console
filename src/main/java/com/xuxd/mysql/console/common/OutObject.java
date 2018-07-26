package com.xuxd.mysql.console.common;

import java.io.Serializable;

/**
 * @Auther: 许晓东
 * @Date: 18-7-22 22:49
 * @Description:
 */
public class OutObject implements Serializable {
    private static final long serialVersionUID = -7789977806258568802L;


    private String returnCode = "0";
    private String returnMessage = "success";

    public OutObject() {
    }

    public OutObject(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public static OutObject success() {
        return new OutObject();
    }

    public static OutObject fail(String returnMessage) {
        return new OutObject(returnMessage);
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

}
