package org.credoBank.testAutomation.myCredo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CardDetails {
    private String cardNickName;
    private String accountNumber;
}
