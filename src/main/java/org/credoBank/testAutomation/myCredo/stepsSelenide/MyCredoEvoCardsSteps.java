package org.credoBank.testAutomation.myCredo.stepsSelenide;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.credoBank.testAutomation.myCredo.elementsSelenide.MyCredoCardsElements;

import java.time.Duration;


public class MyCredoEvoCardsSteps extends MyCredoCardsElements {
    public double findHighestEvoCard() {
        SelenideElement highestCard = null;//შეინახავს ბარათის ელემენტს უმაღლესი ბალანსით
        double highestValue = 0; // შეინახავს უმაღლეს ბალანსის მნიშვნელობას

        evoCards.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10));

        for (SelenideElement card : evoCards) {
            SelenideElement nameElement = card.$(cardName.getSearchCriteria()).shouldBe(visible);
            String cardNameText = nameElement.getText().trim();

            if (cardNameText.equals("Evo Card")) {
                //პოულობს ბალანსის ელემენტს
                SelenideElement balanceElement = card.$(cardsBalance.getSearchCriteria()).shouldBe(visible);
                String balanceText = balanceElement.getText().trim();

                if (!balanceText.isEmpty()) {
                    try {
                        double balance = Double.parseDouble(balanceText.replaceAll("[^\\d.]", ""));
                        System.out.println("Found Evo Card with balance: " + balance);

                        if (balance > highestValue) {
                            highestValue = balance;
                            highestCard = card;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing balance: " + balanceText);
                    }
                }
            }
        }
        //თუ ნაპოვნია ბარათი, ბეჭდავს ბალანსს და აჭერს ბარათს
        if (highestCard != null) {
            System.out.println("The highest Evo card has a balance of: " + highestValue);
            highestCard.click();
        } else {
            System.out.println("No Evo cards found.");
        }

        return highestValue;
    }
}
