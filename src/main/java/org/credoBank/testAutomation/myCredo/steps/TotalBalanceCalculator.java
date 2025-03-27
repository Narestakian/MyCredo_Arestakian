package org.credoBank.testAutomation.myCredo.steps;
import org.credoBank.testAutomation.myCredo.api.CurrencyConversionService;
import org.credoBank.testAutomation.myCredo.models.BalanceAndCurrency;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalBalanceCalculator {
    private final UserCardSteps userCardSteps;
    private final CurrencyConversionService conversionService;

    public TotalBalanceCalculator() {
        this.userCardSteps = new UserCardSteps();
        this.conversionService = new CurrencyConversionService();
    }

    public double calculateTotalBalance() {
        // Step 1: მოიძიე Evo Card-ის ბალანსები
        userCardSteps.checkEvoCardAndBalances();
        List<BalanceAndCurrency> evoBalances = userCardSteps.getRetrievedBalances();

        // Step 2: გამოთვალე GEL ბალანსი
        double totalGELBalance = evoBalances.stream()
                .filter(b -> "GEL".equals(b.getCurrency()))
                .mapToDouble(BalanceAndCurrency::getAvailableBalance)
                .sum();

        // Step 3: კონვერტირება უცხოური ვალუტები -> GEL
        List<BalanceAndCurrency> foreignCurrencyBalances = evoBalances.stream()
                .filter(b -> !"GEL".equals(b.getCurrency()))
                .collect(Collectors.toList());

        Map<String, Double> convertedBalances = conversionService.convertToGel(foreignCurrencyBalances);
        double totalConvertedBalance = convertedBalances.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        // Step 4: ჯამური ბალანსი
        double totalBalance = totalGELBalance + totalConvertedBalance;

        System.out.println("GEL ბალანსი: " + totalGELBalance);
        System.out.println("კონვერტირებული ბალანსი: " + totalConvertedBalance);
        System.out.println("ჯამური ბალანსი: " + totalBalance);

        return totalBalance;
    }
}