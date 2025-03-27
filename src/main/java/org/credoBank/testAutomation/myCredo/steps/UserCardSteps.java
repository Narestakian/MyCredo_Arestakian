package org.credoBank.testAutomation.myCredo.steps;
import io.restassured.response.Response;
import org.credoBank.testAutomation.myCredo.api.TokenCalls_TotalBalance;
import org.credoBank.testAutomation.myCredo.models.BalanceAndCurrency;
import org.credoBank.testAutomation.myCredo.data.CardDetails;
import org.credoBank.testAutomation.myCredo.data.DataControllerTokenService;
import org.credoBank.testAutomation.myCredo.api.TokenCalls_CardsName;
import java.util.Comparator;
import java.util.List;
import static org.testng.Assert.*;

public class UserCardSteps {

    DataControllerTokenService tokenService = new DataControllerTokenService();
    TokenCalls_CardsName tokenCalls = new TokenCalls_CardsName();
    TokenCalls_TotalBalance balanceCalls = new TokenCalls_TotalBalance();
    private List<BalanceAndCurrency> retrievedBalances;

    public void checkEvoCardAndBalances() {
        // Step 1: მივიღოთ ტოკენი
        tokenService.getBearerToken();
        String token = tokenService.getToken();
        assertNotNull(token, "ტოკენი არ უნდა იყოს null");

        // Step 2: მივიღოთ Evo Card-ის ინფორმაცია
        Response cardsResponse = tokenCalls.getCardsByNickName(token);
        System.out.println("ბარათის ინფორმაცია: " + cardsResponse.asString());

        // Step 3: CardDetails-ის ამოღება
        CardDetails cardDetails = cardsResponse.jsonPath().getObject("data[0]", CardDetails.class);
        assertEquals(cardDetails.getCardNickName(), "Evo Card", "ბარათის სახელი არ ემთხვევა!");

        // Step 4: ანგარიშის ნომრის შენახვა
        String evoCardAccountNumber = cardDetails.getAccountNumber();
        System.out.println("Evo Card-ის ანგარიშის ნომერი: " + evoCardAccountNumber);

        // Step 5: მივიღოთ ყველა ანგარიშის ბალანსი
        Response balancesResponse = balanceCalls.getTotalBalance(token);
        System.out.println("ბალანსების ინფორმაცია: " + balancesResponse.asString());


        // Step 6: მხოლოდ Evo Card-ის ანგარიშების გაფილტვრა და მაქსიმალური ბალანსის პოვნა
        List<BalanceAndCurrency> allBalances = balancesResponse.jsonPath().getList("data", BalanceAndCurrency.class);

// 6.1: გაფილტვრა Evo Card-ის ანგარიშების
        List<BalanceAndCurrency> evoBalances = allBalances.stream()
                .filter(b -> evoCardAccountNumber.equals(b.getAccountNumber()))
                .toList();
        this.retrievedBalances = allBalances;

// 6.2: მაქსიმალური ბალანსის პოვნა
        BalanceAndCurrency maxBalanceCurrency = evoBalances.stream()
                .max(Comparator.comparingDouble(BalanceAndCurrency::getAvailableBalance))
                .orElse(null);

// 6.3: მაქსიმალური ბალანსის დამოწმება
        if (maxBalanceCurrency != null) {
            System.out.println("მაქსიმალური ბალანსის მქონე ვალუტა:");
            System.out.println("ვალუტა: " + maxBalanceCurrency.getCurrency());
            System.out.println("მაქსიმალური ბალანსი: " + maxBalanceCurrency.getAvailableBalance());

            // ასერტი რომ მაქსიმალური ბალანსი ნამდვილად Evo Card-ისაა
            assertEquals(maxBalanceCurrency.getAccountNumber(), evoCardAccountNumber,
                    "მაქსიმალური ბალანსი უნდა ეკუთვნოდეს Evo Card-ის ანგარიშს");

            // ასერტი რომ მაქსიმალური ბალანსი არ არის უარყოფითი
            assertTrue(maxBalanceCurrency.getAvailableBalance() >= 0,
                    "მაქსიმალური ბალანსი არ უნდა იყოს უარყოფითი");
        } else {
            System.out.println("მაქსიმალური ბალანსი ვერ მოიძებნა");
            fail("Evo Card-ისთვის მაქსიმალური ბალანსი ვერ მოიძებნა");
        }

        // Step 8: დავბეჭდოთ ყველა ვალუტა და ბალანსი
        System.out.println("Evo Card-ის ანგარიშების ბალანსები:");
        for (BalanceAndCurrency balance : evoBalances) {
            System.out.println("ვალუტა: " + balance.getCurrency());
            System.out.println("ხელმისაწვდომი ბალანსი: " + balance.getAvailableBalance());

            // დამატებითი ვალიდაციები
            assertNotNull(balance.getCurrency(), "ვალუტა არ უნდა იყოს null");
            assertTrue(balance.getAvailableBalance() >= 0,
                    "ბალანსი არ უნდა იყოს უარყოფითი");
        }

    }
    public List<BalanceAndCurrency> getRetrievedBalances() {
        return this.retrievedBalances;
    }
}