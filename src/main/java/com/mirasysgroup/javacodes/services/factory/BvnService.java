package com.mirasysgroup.javacodes.services.factory;

import com.mirasysgroup.javacodes.enums.KycTypes;
import com.mirasysgroup.javacodes.models.KycDataDto;
import com.mirasysgroup.javacodes.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BvnService implements KycServices{
    @Override
    public ResponseEntity<Response> fetchKycService(String validationType, KycDataDto kycDataDto) {
        return new ResponseEntity<>(Response.builder().description("something in BVN").build(), HttpStatus.OK);
    }

    @Override
    public String getValidationType() {
        return KycTypes.BVN.name();
    }
}
