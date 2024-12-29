package com.mirasysgroup.javacodes.models;

import java.util.List;

public class CustomError {
    private String code;
    private String description;

    public CustomError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public CustomError(String field, String defaultMessage, List<String> errors) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
