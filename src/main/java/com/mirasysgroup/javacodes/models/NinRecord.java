package com.mirasysgroup.javacodes.models;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


public class NinRecord {
    @Size(min = 11,max = 11, message = "The number must be exactly 11 characters")
    private String ninNumber;
    @Size(min = 11,max = 11, message = "The number must be exactly 11 characters")
    private String agentPhoneNo;
    @NotBlank(message = "first name cannot be empty")
    private String ninFirstName;
    @NotBlank(message = "last name cannot be empty")
    private String ninLastName;
    private String ninPhoneNumber;
    @NotBlank(message = "status cannot be empty")
    private String ninVerificationStatus;
    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    public String getNinNumber() {
        return ninNumber;
    }

    public void setNinNumber(String ninNumber) {
        this.ninNumber = ninNumber;
    }

    public String getAgentPhoneNo() {
        return agentPhoneNo;
    }

    public void setAgentPhoneNo(String agentPhoneNo) {
        this.agentPhoneNo = agentPhoneNo;
    }

    public String getNinFirstName() {
        return ninFirstName;
    }

    public void setNinFirstName(String ninFirstName) {
        this.ninFirstName = ninFirstName;
    }

    public String getNinLastName() {
        return ninLastName;
    }

    public void setNinLastName(String ninLastName) {
        this.ninLastName = ninLastName;
    }

    public String getNinPhoneNumber() {
        return ninPhoneNumber;
    }

    public void setNinPhoneNumber(String ninPhoneNumber) {
        this.ninPhoneNumber = ninPhoneNumber;
    }

    public String getNinVerificationStatus() {
        return ninVerificationStatus;
    }

    public void setNinVerificationStatus(String ninVerificationStatus) {
        this.ninVerificationStatus = ninVerificationStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
