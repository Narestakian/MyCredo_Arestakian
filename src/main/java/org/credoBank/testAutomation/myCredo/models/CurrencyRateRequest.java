package org.credoBank.testAutomation.myCredo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyRateRequest {
    private String currency;

    @JsonProperty("ChannelTypeId")
    private int channelTypeId;

    @JsonProperty("ChanelId")
    private int channelId;
}
