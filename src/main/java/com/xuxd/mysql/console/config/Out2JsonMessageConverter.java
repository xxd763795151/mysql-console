package com.xuxd.mysql.console.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * @Auther: 许晓东
 * @Date: 18-7-22 23:20
 * @Description: 简单的处理一下，将出参转换成JSON对象
 */
public class Out2JsonMessageConverter extends AbstractHttpMessageConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Out2JsonMessageConverter.class);

    @Override
    protected boolean supports(Class clazz) {
        return false;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
