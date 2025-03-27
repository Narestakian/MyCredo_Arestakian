package org.credoBank.testAutomation.myCredo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BalanceAndCurrency {

    public String accountNumber;
    public double availableBalance;
    public String currency;
}

