package com.mirasysgroup.javacodes.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TinRecord {
    private long agentId;
    @Min(value = 11, message = "The number must be exactly 11")
    @Max(value = 11, message = "The number must be exactly 11")
    private String tinNumber;
    private String taxPayerName;
    @NotNull(message = "cac reg no. cannot be empty")
    private String cacRegNo;
    private String entityType;
    private String jitTin;
    private String taxOffice;
    private String tinPhoneNumber;
    private String tinEmail;
    private String agentPhoneNo;
    private String tinVerificationStatus;
}
