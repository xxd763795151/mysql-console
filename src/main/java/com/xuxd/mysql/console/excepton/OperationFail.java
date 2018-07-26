package com.xuxd.mysql.console.excepton;

/**
 * @Auther: 许晓东
 * @Date: 18-7-22 22:36
 * @Description:
 */
public class OperationFail extends ConsoleException {

    public OperationFail(String message) {
        super("-9999", message);
    }
}
