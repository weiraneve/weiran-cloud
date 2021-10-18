package com.weiran.uaa;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.weiran.uaa.mapper")
@SpringBootApplication
public class UaaApplication {

    public static void main(String[] args) {
//        ElasticApmAttacher.attach(); // 集成Elastic APM的Attach API TODO 这里E、K 似乎与APM有一定的环境bug
        SpringApplication.run(UaaApplication.class, args);
        System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
