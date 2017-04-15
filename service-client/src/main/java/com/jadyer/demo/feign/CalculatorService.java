package com.jadyer.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//绑定該接口到服务网关的jadyer-api-gateway服务，并通知Feign组件对该接口进行代理（不需要编写接口实现）
@FeignClient(value="jadyer-api-gateway", fallback=HystrixCalculatorService.class)
interface CalculatorService {
    ////@PathVariable這種也是支持的
    //@RequestMapping(value="/mycall/add/{a}", method=RequestMethod.GET)
    //int myadd(@PathVariable("a") int a, @RequestParam("b") int b);

    //通过SpringMVC的注解来配置所綁定的服务下的具体实现
    @RequestMapping(value="/mycall/add", method=RequestMethod.GET)
    String myadd(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("accesstoken") String accesstoken);
}