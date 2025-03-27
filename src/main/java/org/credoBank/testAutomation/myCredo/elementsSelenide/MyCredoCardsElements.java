package org.credoBank.testAutomation.myCredo.elementsSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MyCredoCardsElements {
    // ყველა ბარათის კონტეინერი
    public ElementsCollection evoCards = $$("div.product.has-card");

    // ბარათის სახელი
    public SelenideElement cardName = $("p.paragraph-14");

    // ბარათის ბალანსი
    public SelenideElement cardsBalance = $("p.block-header-caps-20");


}
