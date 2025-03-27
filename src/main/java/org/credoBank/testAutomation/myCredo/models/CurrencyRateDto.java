package org.credoBank.testAutomation.myCredo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyRateDto {
    @JsonProperty("CurrencyId")
    private int CurrencyId;

    @JsonProperty("Currency")
    private String Currency;

    @JsonProperty("BuyRate")
    private double BuyRate;

    @JsonProperty("SellRate")
    private double SellRate;

    @JsonProperty("NBGRate")
    private double NBGRate;

    @JsonProperty("IsDivide")
    private boolean IsDivide;
}
