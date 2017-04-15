package com.jadyer.demo;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ServiceGateway02BootStarp {
    @Bean
    public ZuulFilter gatewayFilter() {
        return new GatewayFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceGateway02BootStarp.class, args);
    }
}