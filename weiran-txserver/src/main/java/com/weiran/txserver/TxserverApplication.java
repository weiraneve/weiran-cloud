package com.weiran.txserver;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 */
@EnableDiscoveryClient
@EnableTransactionManagerServer
@SpringBootApplication
public class TxserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxserverApplication.class, args);
    }

}
