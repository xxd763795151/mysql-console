package com.xuxd.mysql.console;

import com.xuxd.mysql.console.annotation.EnableEhcache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Auther: 许晓东
 * @Date: 18-7-14 21:45
 * @Description:
 */

@SpringBootApplication
//@EnableCaching
@EnableEhcache
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
