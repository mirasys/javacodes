package com.mirasysgroup.javacodes.services.factory;

import org.springframework.stereotype.Service;

@Service
public interface KycServices {
    String fetchKycService(String validationType);
    String getValidationType();
}
