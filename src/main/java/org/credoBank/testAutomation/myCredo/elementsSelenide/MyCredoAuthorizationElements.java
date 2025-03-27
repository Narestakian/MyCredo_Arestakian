package org.credoBank.testAutomation.myCredo.elementsSelenide;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class MyCredoAuthorizationElements {
    public SelenideElement userName = $x("//input[@id='userName']");
    public SelenideElement password = $x("//input[@id='newPass']");
    public SelenideElement submitButton = $x("//button[@id='submitAuth']");
    public SelenideElement otpInput = $("#otpCodeInput");
    public SelenideElement otpSubmitButton = $x("//button[contains(text(), 'დადასტურება')]");
    public ElementsCollection easyAuthCloseButton = $$(".icon.close-black.grey-010.pointer");
}
