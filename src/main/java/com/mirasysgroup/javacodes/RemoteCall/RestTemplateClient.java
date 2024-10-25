package com.mirasysgroup.javacodes.RemoteCall;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mirasysgroup.javacodes.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestTemplateClient {

    @Autowired
    private Gson gson;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

    public ResponseEntity<byte[]> postCallRequestHeaders(String url, HttpHeaders headers, Object request){
        try{
            String requestBody = gson.toJson(request);
            HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class,requestBody);
            log.info("Remote call response: {}", response);
            return response;
        } catch(RestClientException ex){
            log.error("Remote call exception: {}",ex);
        }
        return null;
    }
//    public Object postCallRequestHeaders(String url, HttpHeaders headers, Object request){
//        try{
//            String requestBody = gson.toJson(request,String.class);
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            Object responseBody = restTemplate.exchange(url, HttpMethod.POST, entity,Object.class,requestBody);
//            log.info("Remote call response: {}", responseBody);
//            return mapper.convertValue();
//        } catch(RestClientException ex){
//            log.error("Remote call exception: {}",ex);
//        }
//        return null;
//    }
}
