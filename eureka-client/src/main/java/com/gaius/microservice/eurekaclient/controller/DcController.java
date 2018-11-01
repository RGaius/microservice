package com.gaius.microservice.eurekaclient.controller;

import com.gaius.microservice.eurekaclient.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date
 */

@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public Result dc() {
        String services = "Services: " + discoveryClient.getServices();
        Result result = new Result();
        result.setName("/doc");
        result.setContent(services);
        System.out.println(services);
        return result;
    }

}
