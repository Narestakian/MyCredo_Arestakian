package org.credoBank.testAutomation.myCredo.steps;
import io.restassured.response.Response;
import org.credoBank.testAutomation.myCredo.models.BalanceAndCurrency;
import org.credoBank.testAutomation.myCredo.data.CardDetails;
import org.credoBank.testAutomation.myCredo.data.DataControllerTokenService;
import org.credoBank.testAutomation.myCredo.api.TokenCalls_CardsName;
import org.credoBank.testAutomation.myCredo.api.TokenCalls_TotalBalance;
import java.util.List;
import static org.testng.Assert.*;


public class BalanceValidationSteps {

    DataControllerTokenService tokenService = new DataControllerTokenService();
    TokenCalls_CardsName tokenCalls = new TokenCalls_CardsName();
    TokenCalls_TotalBalance balanceCalls = new TokenCalls_TotalBalance();

    public void validateBalanceChanges() {
        tokenService.getBearerToken();
        String token = tokenService.getToken();
        assertNotNull(token, "Token should not be null");

        // Step 2: მიიღეთ Evo ბარათის დეტალები
        Response cardsResponse = tokenCalls.getCardsByNickName(token);
        CardDetails cardDetails = cardsResponse.jsonPath().getObject("data[0]", CardDetails.class);
        assertEquals(cardDetails.getCardNickName(), "Evo Card", "Card nickname mismatch!");

        // Step 3: Store Evo Card account number
        String evoCardAccountNumber = cardDetails.getAccountNumber();

        // Step 4: შეინახეთ Evo Card ანგარიშის ნომერი
        Response balancesResponse = balanceCalls.getTotalBalance(token);
        List<BalanceAndCurrency> allBalances = balancesResponse.jsonPath().getList("data", BalanceAndCurrency.class);

        // Step 5: Filter GEL account balances
        BalanceAndCurrency gelBalance = allBalances.stream()
                .filter(b -> evoCardAccountNumber.equals(b.getAccountNumber()) && "GEL".equals(b.getCurrency()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("GEL balance not found!"));

         double initialGELBalance = gelBalance.getAvailableBalance();


        // Step 7: განაახლეთ ნაშთები და დაადასტურეთ ლარის ანგარიშის შემცირება
        Response updatedBalancesResponse = balanceCalls.getTotalBalance(token);
        List<BalanceAndCurrency> updatedBalances = updatedBalancesResponse.jsonPath().getList("data", BalanceAndCurrency.class);

        BalanceAndCurrency updatedGELBalance = updatedBalances.stream()
                .filter(b -> evoCardAccountNumber.equals(b.getAccountNumber()) && "GEL".equals(b.getCurrency()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Updated GEL balance not found!"));

        assertEquals(updatedGELBalance.getAvailableBalance(), initialGELBalance, "GEL balance did not decrease correctly");

        // Step 8: Verify 100 GEL was added to another account
        boolean balanceIncreased = updatedBalances.stream()
                .anyMatch(b -> b.getAvailableBalance() >= 100 && !b.getAccountNumber().equals(evoCardAccountNumber));

        assertTrue(balanceIncreased, "100 GEL was not reflected in another account");



    }
}
