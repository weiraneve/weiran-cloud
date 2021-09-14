package com.weiran.oauth2_A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2_A_Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2_A_Application.class, args);
        System.out.println("\nSa-Token-OAuth Client端启动成功\n");
    }
}
