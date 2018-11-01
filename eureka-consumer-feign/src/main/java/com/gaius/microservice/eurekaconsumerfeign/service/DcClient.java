package com.gaius.microservice.eurekaconsumerfeign.service;

import com.gaius.microservice.eurekaconsumerfeign.vo.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface DcClient {
    @GetMapping("/dc")
    String consumer();
}
