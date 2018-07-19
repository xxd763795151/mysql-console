package com.xuxd.mysql.console.annotation;

import com.xuxd.mysql.console.config.EhcacheConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Auther: 许晓东
 * @Date: 18-7-19 10:04
 * @Description: 启用ehcache， spring boot cache不好用，不适合自己的场景，所以就自己封装一个喽
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EhcacheConfig.class)
public @interface EnableEhcache {
}
