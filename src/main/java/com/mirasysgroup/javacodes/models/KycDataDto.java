package com.mirasysgroup.javacodes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Ignores fields with null values
public class KycDataDto {
    @Valid
    private NinRecord ninRecord;
    @Valid
    private CacRecord cacRecord;
    @Valid
    private TinRecord tinRecord;

    public NinRecord getNinRecord() {
        return ninRecord;
    }

    public void setNinRecord(NinRecord ninRecord) {
        this.ninRecord = ninRecord;
    }

    public CacRecord getCacRecord() {
        return cacRecord;
    }

    public void setCacRecord(CacRecord cacRecord) {
        this.cacRecord = cacRecord;
    }

    public TinRecord getTinRecord() {
        return tinRecord;
    }

    public void setTinRecord(TinRecord tinRecord) {
        this.tinRecord = tinRecord;
    }
}
