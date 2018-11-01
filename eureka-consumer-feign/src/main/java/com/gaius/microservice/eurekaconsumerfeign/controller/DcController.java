package com.gaius.microservice.eurekaconsumerfeign.controller;

import com.gaius.microservice.eurekaconsumerfeign.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date
 */

@RestController
public class DcController {
    @Autowired
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }
}
