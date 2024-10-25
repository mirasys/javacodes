package com.mirasysgroup.javacodes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private String code;
    private String description;
    private Object data;
    private HttpStatusCode httpStatusCode;
    private HttpStatus httpStatus;
    private String message;

}
