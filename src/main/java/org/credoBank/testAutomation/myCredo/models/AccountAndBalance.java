package org.credoBank.testAutomation.myCredo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AccountAndBalance {
    private String accountNumber;
    private double balance;
    private String currency;
    private String availableBalance;
    private String accountItemId;
}
