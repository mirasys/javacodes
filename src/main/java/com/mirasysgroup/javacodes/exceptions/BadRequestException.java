package com.mirasysgroup.javacodes.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException{
    private String code;
    private String message;
}
