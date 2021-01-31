package com.lifeonline.servicelive;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



/**
 * @author HHY
 */
@ComponentScan(basePackages = {"com.lifeonline.sso"})
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
public class LiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveApplication.class,args);
    }

}
