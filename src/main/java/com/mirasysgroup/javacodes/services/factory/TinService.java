package com.mirasysgroup.javacodes.services.factory;

import com.mirasysgroup.javacodes.enums.KycTypes;
import org.springframework.stereotype.Component;

@Component
public class TinService implements KycServices{
    @Override
    public String fetchKycService(String validationType) {
        return "This is TIN service";
    }

    @Override
    public String getValidationType() {

        return KycTypes.TIN.name();
    }
}
