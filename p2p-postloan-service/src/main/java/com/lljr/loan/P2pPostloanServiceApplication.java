package com.lljr.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableEurekaClient
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class P2pPostloanServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(P2pPostloanServiceApplication.class, args);
    }
}
