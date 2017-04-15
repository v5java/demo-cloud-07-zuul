package com.jadyer.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置内容的热加载：http://127.0.0.1:2100/refresh（curl -X POST http://10.16.18.95:2100/refresh）（大写的X和POST）
 * 注意：需要显式标注@RefreshScope，则即使调用/refresh，配置也不会刷新
 * 注意：它依赖spring-boot-starter-actuator，否则/refresh时会得到404
 * ------------------------------------------------------------------------------------------
 * 这里bootstrap.yml里面的配置，不能放到application.yml里面，否则config部分无法被加载
 * （仔细想想也是这个道理，两个spring.application.name它也冲突啊）
 * 这是因为config部分的配置要先于application.yml被加载，而bootstrap.yml中的配置会先于application.yml加载
 * ------------------------------------------------------------------------------------------
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigDemoController {
    //获取配置中心的属性
    @Value("${host.ifs}")
    private String ifsHost;

    @GetMapping("/getHost")
    public String getHost(){
        return this.ifsHost;
    }
}