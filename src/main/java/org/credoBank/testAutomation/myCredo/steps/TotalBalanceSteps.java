
package org.credoBank.testAutomation.myCredo.steps;
import io.restassured.response.Response;
import org.credoBank.testAutomation.myCredo.models.AccountAndBalance;
import org.credoBank.testAutomation.myCredo.data.DataControllerTokenService;
import org.credoBank.testAutomation.myCredo.elementsSelenide.MyCredoCardsElements;
import org.credoBank.testAutomation.myCredo.api.TokenCalls_TotalBalance;
import org.credoBank.testAutomation.myCredo.stepsSelenide.MyCredoEvoCardsSteps;

import java.util.List;
import java.util.Optional;

public class TotalBalanceSteps extends MyCredoCardsElements {
    double availableBalance = 0;
    DataControllerTokenService tokenService = new DataControllerTokenService();
    TokenCalls_TotalBalance tokenCallsTotalBalance = new TokenCalls_TotalBalance();
    MyCredoEvoCardsSteps evoCardsSteps = new MyCredoEvoCardsSteps();

    public double getTokenAndTotalBalance() {

        // Step 1: მივიღოთ ტოკენი sessionStorage-დან
        tokenService.getBearerToken();
        String token = tokenService.getToken();


        // Step 2: მივიღოთ ბალანსის ინფორმაცია
        Response response = tokenCallsTotalBalance.getTotalBalance(token);
        List<AccountAndBalance> accounts = response.jsonPath().getList("data", AccountAndBalance.class);

        // Step 3: იპოვეთ პირველი ანგარიში (ან სხვა ლოგიკა, რომელიც გჭირდებათ)
        Optional<AccountAndBalance> targetAccount = accounts.stream()
                .findFirst(); // პირველი ანგარიშის აღება (ან სხვა ფილტრაცია, თუ საჭიროა)

        if (targetAccount.isPresent()) {
            availableBalance = Double.parseDouble(targetAccount.get().getAvailableBalance()); // შეინახეთ availableBalance
            System.out.println("Account Number: " + targetAccount.get().getAccountNumber());
            System.out.println("Available Balance: " + availableBalance);
        } else {
            System.out.println("No accounts found.");
        }

        return availableBalance; // დააბრუნეთ availableBalance

    }


        // შედარება
        public void compareBalances() {
            double highestBalance = evoCardsSteps.findHighestEvoCard();
            double availableBalance = getTokenAndTotalBalance();

            if (highestBalance == availableBalance) {
                System.out.println("The highest balance matches the available balance: " + highestBalance);
            } else if (highestBalance > availableBalance) {
                System.out.println("The highest balance is greater than the available balance.");
                System.out.println("Highest Balance: " + highestBalance);
                System.out.println("Available Balance: " + availableBalance);
            } else {
                System.out.println("The available balance is greater than the highest balance.");
                System.out.println("Available Balance: " + availableBalance);
                System.out.println("Highest Balance: " + highestBalance);
            }
        }

}
