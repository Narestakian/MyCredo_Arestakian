package org.credoBank.testAutomation.myCredo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRateResponse {
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("Version")
    private String Version;
    @JsonProperty("StatusCode")
    private int StatusCode;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Result")
    private List<CurrencyRateDto> Result;
}
