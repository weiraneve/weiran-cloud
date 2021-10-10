package com.weiran.missionplanning.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * discription: 启动类
 * ComponentScan注解必须要，这种子模块之间Bean的管理需要这个注解
 */
@SpringBootApplication
@ComponentScan("com.weiran")
public class MissionPlanningApplication {
    public static void main(String[] args) {
        SpringApplication.run(MissionPlanningApplication.class, args);
    }
}
