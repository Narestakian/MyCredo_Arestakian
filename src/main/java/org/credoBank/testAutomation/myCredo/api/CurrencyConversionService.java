package org.credoBank.testAutomation.myCredo.api;
import org.credoBank.testAutomation.myCredo.models.BalanceAndCurrency;
import org.credoBank.testAutomation.myCredo.models.CurrencyRateRequest;
import org.credoBank.testAutomation.myCredo.models.CurrencyRateResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyConversionService {

    public Map<String, Double> convertToGel(List<BalanceAndCurrency> balances) {
        // 1. მივიღოთ კურსები
        CurrencyRateResponse rates = new CurrencyRateService().getCurrencyRates(
                CurrencyRateRequest.builder()
                        .currency("GEL")
                        .channelTypeId(8)
                        .channelId(98)
                        .build()
        ).as(CurrencyRateResponse.class);
        System.out.println("მიღებული კურსები: " + rates.getResult());

        // 2. დავაკონვერტიროთ მხოლოდ უცხოური ვალუტები
        return balances.stream()
                .filter(b -> !"GEL".equals(b.getCurrency()))
                .collect(Collectors.toMap(
                        BalanceAndCurrency::getCurrency,
                        b -> b.getAvailableBalance() * getRate(b.getCurrency(), rates),
                        (existing, replacement) -> existing // თუ უკვე არსებობს "USD", არ დაგვუბრუნდება შეცდომა
                ));
    }

    private double getRate(String currency, CurrencyRateResponse rates) {
        System.out.println("კურსების ძებნა: " + currency);

        return rates.getResult().stream()
                .peek(rate -> System.out.println("მიმდინარე კურსი: " + rate.getCurrency()))  // ლოგი დამატებულია
                .filter(r -> currency.equals(r.getCurrency()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("კურსი ვერ მოიძებნა: " + currency))
                .getSellRate();
    }
    }

