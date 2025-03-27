package org.credoBank.testAutomation.myCredo.stepsSelenide;

import com.codeborne.selenide.Condition;
import org.credoBank.testAutomation.myCredo.elementsSelenide.CardSwitchedElements;

public class CardSwitchedSteps extends CardSwitchedElements {
    public void cardSwitchedToAnotherCard(){
        switchAnotherCardButton.click();

    }

    public void returnToEvoCard(){
        returnEvoCardButton.click();
    }
}
