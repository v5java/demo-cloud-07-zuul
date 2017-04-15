package com.jadyer.demo.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HystrixCalculatorService implements CalculatorService {
    @Override
    public int myadd(@RequestParam("a") int a, @RequestParam("b") int b) {
        return -999;
    }
}