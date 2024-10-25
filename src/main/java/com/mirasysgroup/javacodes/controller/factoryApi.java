package com.mirasysgroup.javacodes.controller;

import com.mirasysgroup.javacodes.services.factory.KycServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/factory-test")
public class factoryApi {

    @Autowired
    KycServiceFactory kycServiceFactory;

    @GetMapping(value = "/test")
    public String test(){
        return "testing controller";
    }

    @GetMapping(value = "/fetch-kyc-route")
    public String fetchKycRoute(@RequestHeader String validationType) throws Exception {

        return kycServiceFactory.getInstance(validationType).fetchKycService(validationType);
    }
}
