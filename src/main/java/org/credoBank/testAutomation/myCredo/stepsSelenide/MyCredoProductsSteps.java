package org.credoBank.testAutomation.myCredo.stepsSelenide;


import org.credoBank.testAutomation.myCredo.elementsSelenide.MyCredoProductsElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class MyCredoProductsSteps  extends MyCredoProductsElements {

    public void clickOnProductsButton(){
        productsButton.shouldBe(visible, enabled).click();

    }

    public void clickAccountAndCardsDropDown(){
        dropDownElement.click();
    }

}
