package com.gaius.microservice.eurekaconsumer.controller;

import com.gaius.microservice.eurekaconsumer.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @date
 */
@RestController
public class DcController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public Result dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, Result.class);
    }
}
