package com.mirasysgroup.javacodes.services.factory;

import com.mirasysgroup.javacodes.models.KycDataDto;
import com.mirasysgroup.javacodes.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface KycServices {
    ResponseEntity<Response> fetchKycService(String validationType, KycDataDto kycDataDto);
    String getValidationType();
}
