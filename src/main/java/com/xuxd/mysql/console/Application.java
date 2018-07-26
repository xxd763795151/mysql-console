package com.xuxd.mysql.console;

import com.xuxd.mysql.console.annotation.EnableEhcache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: 许晓东
 * @Date: 18-7-14 21:45
 * @Description:
 */

@SpringBootApplication
@EnableEhcache
public class Application {

    public static void main(String[] args) {
        System.setProperty(net.sf.ehcache.CacheManager.ENABLE_SHUTDOWN_HOOK_PROPERTY,"true");
        SpringApplication.run(Application.class, args);
    }
}
