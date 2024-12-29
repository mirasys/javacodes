package com.mirasysgroup.javacodes.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CacRecord {
    private long agentId;
    @Min(value = 11, message = "The number must be exactly 11")
    @Max(value = 11, message = "The number must be exactly 11")
    private String rcNumber;
    private String agentPhoneNo;
    @NotNull(message = "status cannot be empty")
    private String cacVerificationStatus;
    @NotNull(message = "classification cannot be empty")
    private String classification;
    private String registrationDate;
    @NotNull(message = "company name cannot be empty")
    private String companyName;
    private String state;
    private String headOfficeAddress;
    private String city;
    @NotNull(message = "email cannot be empty")
    private String companyEmail;
    private String branchAddress;
    private String lga;
    private String companyType;
}
