package com.mirasysgroup.javacodes.controller;

import com.mirasysgroup.javacodes.models.KycDataDto;
import com.mirasysgroup.javacodes.models.Response;
import com.mirasysgroup.javacodes.services.factory.KycServiceFactory;
import com.mirasysgroup.javacodes.utils.TransactionUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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

    @PostMapping(value = "/fetch-kyc-route")
    public ResponseEntity<Response> fetchKycRoute(@Valid @RequestBody KycDataDto kycDataDto,@RequestHeader String validationType){
//        if (TransactionUtils.getFieldErrors(errors) != null){
//            return new ResponseEntity<>(Response.builder().data(errors).build(), HttpStatus.BAD_REQUEST);
//        }
        return kycServiceFactory.getInstance(validationType).fetchKycService(validationType, kycDataDto);
    }
}
