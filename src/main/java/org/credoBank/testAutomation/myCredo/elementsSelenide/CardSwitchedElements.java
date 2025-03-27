package org.credoBank.testAutomation.myCredo.elementsSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CardSwitchedElements {
    public SelenideElement switchAnotherCardButton = $("#selectNextProduct");
    public SelenideElement returnEvoCardButton = $("button[id='selectPreviousProduct']");
}
