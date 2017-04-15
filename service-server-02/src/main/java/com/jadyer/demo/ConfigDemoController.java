package com.jadyer.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigDemoController {
    @Value("${host.ifs}")
    private String ifsHost;

    @GetMapping("/getHost")
    public String getHost(){
        return this.ifsHost;
    }
}