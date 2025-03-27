package org.credoBank.testAutomation.myCredo.elementsSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CardPinChangeElements {
    public SelenideElement pinResetButton = $("#pinReset.pin-reset");
    public SelenideElement closePinResetButton = $("#closePinReset");
    public SelenideElement closeIcon = $("div[_ngcontent-ng-c3908597554][class='icon close-black grey-010 pointer']");
    public SelenideElement evoCardOtpName = $x("//p[@_ngcontent-ng-c3908597554 and contains(text(),'Evo Card')]");
    public SelenideElement confirmEvoCardOtpButton = $x("//form[contains(@class, 'otp-container')]//button[@type='submit' and contains(text(), 'დადასტურება')]");
    public SelenideElement resetPinButton = $("button#resetPin.primary");
    public SelenideElement evoCardOtpCodeInput = $("#otpCodeInput");
    public SelenideElement notificationPanel = $("app-notification-panel");
    public SelenideElement closeNotificationButton = $x("//div[contains(@class, 'icon white-010 close pointer')]");


}
