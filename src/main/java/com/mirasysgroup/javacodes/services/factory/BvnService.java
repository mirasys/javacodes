package com.mirasysgroup.javacodes.services.factory;

import com.mirasysgroup.javacodes.enums.KycTypes;
import org.springframework.stereotype.Component;

@Component
public class BvnService implements KycServices{
    @Override
    public String fetchKycService(String validationType) {
        return "This is BVN service";
    }

    @Override
    public String getValidationType() {

        return KycTypes.BVN.name();
    }
}
