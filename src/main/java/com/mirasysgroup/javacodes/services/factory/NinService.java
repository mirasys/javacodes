package com.mirasysgroup.javacodes.services.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mirasysgroup.javacodes.enums.KycTypes;
import com.mirasysgroup.javacodes.models.KycDataDto;
import com.mirasysgroup.javacodes.models.NinRecord;
import com.mirasysgroup.javacodes.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class NinService implements KycServices{
    @Override
    public ResponseEntity<Response> fetchKycService(String validationType, KycDataDto kycDataDto) {
        log.info("{}",kycDataDto.getNinRecord());
        // cast object to class
        NinRecord record = new ObjectMapper().convertValue(kycDataDto.getNinRecord(), NinRecord.class);
        //sanitize and validate inputs
        //return object back to client
        return new ResponseEntity<>(Response.builder().description("something in NIN")
                .data(record).build(), HttpStatus.OK);
    }

    @Override
    public String getValidationType() {

        return KycTypes.NIN.name();
    }
}
