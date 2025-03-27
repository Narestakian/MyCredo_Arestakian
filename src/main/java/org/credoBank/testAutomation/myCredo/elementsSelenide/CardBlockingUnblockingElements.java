package org.credoBank.testAutomation.myCredo.elementsSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CardBlockingUnblockingElements {
    public SelenideElement cardBlockButton = $("#cardStatusId");
    public SelenideElement cardCancelButton = $("#popupCard");
    public SelenideElement closePopupButton = $x("//p[contains(text(), 'Evo Card')]/ancestor::div[contains(@class, 'txt')]/following-sibling::div[contains(@class, 'icon') and contains(@class, 'close-black') and contains(@class, 'pointer')]");
    public SelenideElement lockCardButton = $("#lockCard");
    public SelenideElement cardUnlockButton = $(".lock");
    public SelenideElement unblockButton = $("#unblock.primary");
    public SelenideElement notificationPanel = $("app-notification-panel");



}
