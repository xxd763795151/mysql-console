package com.xuxd.mysql.console.common;

import java.io.Serializable;
import static com.xuxd.mysql.console.common.Constants.*;

/**
 * @Auther: 许晓东
 * @Date: 18-7-22 22:49
 * @Description:
 */
public class OutObject implements Serializable {

    private static final long serialVersionUID = -7789977806258568802L;


    private String returnCode = SUCCESS_CODE;
    private String returnMessage = "success";

    public OutObject() {
    }

    public OutObject(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public OutObject(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public static OutObject success() {
        return new OutObject();
    }
    public static OutObject success(String returnMessage) {
        return new OutObject(returnMessage);
    }

    public static OutObject fail(String returnMessage) {
        return new OutObject(ERROR_CODE, returnMessage);
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
