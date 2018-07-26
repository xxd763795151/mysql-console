package com.xuxd.mysql.console.excepton;

import com.xuxd.mysql.console.common.OutObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.xuxd.mysql.console.common.Constants.*;
/**
 * @Auther: 许晓东
 * @Date: 18-7-17 16:49
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public OutObject handle(Exception e) {
        LOGGER.error("异常信息", e);
        if (e instanceof ConsoleException) {
            return OutObject.fail(e.getMessage());
        } else {
            ConsoleException exception = new ConsoleException(ERROR_CODE, "未知错误：" + e.getMessage());
            return OutObject.fail(exception.toJsonString());
        }
    }
}
