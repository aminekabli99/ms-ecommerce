package com.amine.customer_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 import java.util.Map;

@RestController
@RefreshScope
public class ConfigRestController {
    @Value("${customer-service.params.x}")
    private String p1;
    @Value("${customer-service.params.x}")
    private String p2;

    @GetMapping("/testConfig1")
    public Map<String,String> getData1(){
        return Map.of("p1",p1, "p2",p2);
    }
}
