package com.mirasysgroup.javacodes.services.factory;

import com.mirasysgroup.javacodes.enums.KycTypes;
import org.springframework.stereotype.Component;

@Component
public class CacKycService implements KycServices{
    @Override
    public String fetchKycService(String validationType) {
        return "This is CAC service";
    }

    @Override
    public String getValidationType() {

        return KycTypes.CAC.name();
    }
}
