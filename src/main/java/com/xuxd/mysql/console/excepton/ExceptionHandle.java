package com.xuxd.mysql.console.excepton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String handle(Exception e) {
        LOGGER.error("", e);
        if (e instanceof ConsoleException) {
            return e.getMessage();
        } else {
            return "error";
        }
    }
}
