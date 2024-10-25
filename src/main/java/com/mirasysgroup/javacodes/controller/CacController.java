package com.mirasysgroup.javacodes.controller;

import com.mirasysgroup.javacodes.models.DownloadCertificate;
import com.mirasysgroup.javacodes.services.remoteServices.CacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/cac")
public class CacController {

    @Autowired
    CacService cacService;
    @PostMapping(value = "/download", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> downloadCertificate(@RequestBody DownloadCertificate downloadCertificate){
        return cacService.downloadCertificate(downloadCertificate);
    }
}
