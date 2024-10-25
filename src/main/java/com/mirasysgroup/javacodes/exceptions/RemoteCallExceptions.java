package com.mirasysgroup.javacodes.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class RemoteCallExceptions extends RuntimeException{
    private String code;
    private String message;
    private Object data;

    public RemoteCallExceptions(){}

    public RemoteCallExceptions(String code, String description) {
        this.code = code;
        this.message = description;
    }

    public RemoteCallExceptions(String code, String description,Object data) {
        this.code = code;
        this.message = description;
        this.data = data;
    }

    public RemoteCallExceptions(Object data){
        this.data = data;
    }

}
