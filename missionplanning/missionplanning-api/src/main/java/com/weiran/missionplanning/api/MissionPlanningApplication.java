package com.weiran.missionplanning.api;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * discription:
 */
@EnableAsync //开启异步操作
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@ServletComponentScan("com.weiran.missionplanning.biz.socket")
@MapperScan("com.weiran.missionplanning.dal.mapper")
@ComponentScan("com.weiran")
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.weiran")
@EnableDistributedTransaction
public class MissionPlanningApplication {
    public static void main(String[] args) {
        SpringApplication.run(MissionPlanningApplication.class, args);
    }
}
