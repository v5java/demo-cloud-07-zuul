package com.jadyer.demo.feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 服务调用方
 * Created by 玄玉<https://jadyer.github.io/> on 2017/1/10 18:23.
 */
@RestController
@RequestMapping("/demo/feign")
public class ConsumerController {
    @Resource
    private CalculatorService calculatorService;

    @RequestMapping("/toadd")
    String toadd(int a, int b, String accesstoken){
        return calculatorService.myadd(a, b, accesstoken);
    }
}