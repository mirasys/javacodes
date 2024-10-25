package com.mirasysgroup.javacodes.services.factory;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class KycServiceFactory {

    private static final Map<String, KycServices> map = new HashMap<>();

    @Autowired
    List<KycServices> kycServicesList;

    @PostConstruct
    public void init(){
        kycServicesList.forEach(x-> map.put(x.getValidationType(),x));
    }

    public KycServices getInstance(String name) throws Exception {
        var service = map.get(name);
        if(Objects.isNull(service))
            throw new Exception("Invalid validation type");
        return service;
    }

}