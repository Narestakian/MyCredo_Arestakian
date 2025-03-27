package org.credoBank.testAutomation.myCredo.stepsSelenide;

import com.codeborne.selenide.Condition;
import org.credoBank.testAutomation.myCredo.elementsSelenide.CardPinChangeElements;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;

public class CardPinChangeSteps  extends CardPinChangeElements {

    public void clickPinResetButton(){
        pinResetButton.click();
    }

    public void clickClosePinResetButton(){
        closePinResetButton.click();
    }

    public void clickCloseIcon(){
        closeIcon.click();
    }

    public void checkOtpEvoCardName(){
        evoCardOtpName.shouldHave(Condition.text("Evo Card"));

    }

    public void checkConfirmEvoCardOtpButton(){
        confirmEvoCardOtpButton.shouldBe(Condition.disabled);
    }

    public void clickResetEvoCardPinButton(){
        resetPinButton.click();
    }

    public void setEvoCardOtp(String otpCodeValue){
        evoCardOtpCodeInput.setValue(otpCodeValue);
        confirmEvoCardOtpButton.click();

    }
    public void checkChangePinMessage() {

        // დაელოდეთ, სანამ შეტყობინება გამოჩნდება
        notificationPanel.shouldBe(Condition.visible, Duration.ofSeconds(10));

        // შეამოწმეთ, რომ შეტყობინება შეიცავს სასურველ ტექსტს
        notificationPanel.shouldHave(text("ახალი პინ კოდი sms-ით გამოგიგზავნეთ"), Duration.ofSeconds(10));

        // ასერტი, რომ შეტყობინება სინამდვილეში გამოჩნდა
        Assert.assertTrue(notificationPanel.isDisplayed(), "შეტყობინება არ ჩანს.");
    }

    public void clickCloseNotificationButton(){
        closeNotificationButton.click();
    }


}
