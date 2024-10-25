package com.mirasysgroup.javacodes.services.remoteServices;

import com.mirasysgroup.javacodes.RemoteCall.RestTemplateClient;
import com.mirasysgroup.javacodes.exceptions.RemoteCallExceptions;
import com.mirasysgroup.javacodes.models.DownloadCertificate;
import com.mirasysgroup.javacodes.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class CacService {

    private static final String CAC_BASE_URL = "http://41.207.248.246:9000/api/vas";
    private static final String DOWNLOAD_PATH = "/engine/certificate";

    public static final String API_KEY = "$2a$10$PBVa6cgfMjgZujwNmMMYyuaG6eubkB3N9ipqHlLaDx3UofuIvtm7e";
    @Autowired
    private RestTemplateClient restTemplateClient;

    public ResponseEntity<byte[]> downloadCertificate(DownloadCertificate downloadCertificate){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X_API_KEY",API_KEY);
        headers.add("Accept", "application/octet-stream");
        headers.add("Content-Type", "application/json");
        var response = restTemplateClient.postCallRequestHeaders(CAC_BASE_URL + DOWNLOAD_PATH, headers,downloadCertificate);
        if(response == null){
            throw new RemoteCallExceptions("500","Error Calling remote server");
        }
        if(!response.getStatusCode().is2xxSuccessful()){
            throw new RemoteCallExceptions(response);
        }
        byte[] file = (byte[]) Objects.requireNonNull(response.getBody());
        return new ResponseEntity<>(file,HttpStatus.OK);
    }
}
