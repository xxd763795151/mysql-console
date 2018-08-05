package com.xuxd.mysql.console.annotation;

import java.lang.annotation.*;

/**
 * @Auther: 许晓东
 * @Date: 18-8-5 16:32
 * @Description: 持久化到磁盘
 */
@Target(ElementType.METHOD)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DiskPersistent {
    /**
     * 持久化的key
     */
    PersistentType value() default PersistentType.SAVE;

}
