package com.xuxd.mysql.console.excepton;
import static com.xuxd.mysql.console.common.Constants.*;
/**
 * @Auther: 许晓东
 * @Date: 18-7-22 22:36
 * @Description:
 */
public class OperationFail extends ConsoleException {

    public OperationFail(String message) {
        super(ERROR_CODE, message);
    }
}
