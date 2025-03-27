package org.credoBank.testAutomation.myCredo.elementsSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferFromAccountElements {
    public SelenideElement transferButton = $("#transfer");
    public SelenideElement transferHeader = $x("//div[contains(@class, 'header')]//p[text()='გადარიცხვა']");

}
