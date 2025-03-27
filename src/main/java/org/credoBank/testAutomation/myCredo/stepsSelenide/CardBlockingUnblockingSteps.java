package org.credoBank.testAutomation.myCredo.stepsSelenide;

import com.codeborne.selenide.Condition;
import org.credoBank.testAutomation.myCredo.elementsSelenide.CardBlockingUnblockingElements;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;

public class CardBlockingUnblockingSteps extends CardBlockingUnblockingElements {

    public void clickCardBlockingUnblockingButton(){
        cardBlockButton.click();
    }

    public void clickCardCancelButton(){
        cardCancelButton.click();
    }

    public void clickClosePopupButton(){
        closePopupButton.click();
    }

    public void clickLockCardButton(){
        lockCardButton.click();
    }

    public void checkCardBlock(){
        // ელემენტი cardBlockButton გაქრება
        cardBlockButton.shouldBe(Condition.disappear, Duration.ofSeconds(10));

     // ელემენტი cardUnlockButton უნდა იყოს ხელმისაწვდომი
        cardUnlockButton.shouldBe(Condition.visible, Duration.ofSeconds(10));

       // ასერტი, რომ cardUnlockButton სინამდვილეში გამოჩნდა
        Assert.assertTrue(cardUnlockButton.isDisplayed(), "ardUnlockButton არ ჩანს.");
        //cardUnlockButton.shouldHave(text("ბარათი წარმატებით დაიბლოკა"), Duration.ofSeconds(10));
    }
    public void checkNotificationBlockedMessage() {

        // დაელოდეთ, სანამ შეტყობინება გამოჩნდება
        notificationPanel.shouldBe(Condition.visible, Duration.ofSeconds(10));

        // შეამოწმეთ, რომ შეტყობინება შეიცავს სასურველ ტექსტს
        notificationPanel.shouldHave(text("ბარათი წარმატებით დაიბლოკა"), Duration.ofSeconds(10));

        // ასერტი, რომ შეტყობინება სინამდვილეში გამოჩნდა
        Assert.assertTrue(notificationPanel.isDisplayed(), "შეტყობინება არ ჩანს.");
    }

    public void clickCardUnblockButton(){
        cardUnlockButton.click();
    }

    public void clickUnblockButton(){
        unblockButton.click();
    }
    public void checkNotificationUnBlockedMessage() {

        // დაელოდეთ, სანამ შეტყობინება გამოჩნდება
        notificationPanel.shouldBe(Condition.visible, Duration.ofSeconds(10));

        // შეამოწმეთ, რომ შეტყობინება შეიცავს სასურველ ტექსტს
        notificationPanel.shouldHave(text("ბარათი წარმატებით განიბლოკა"), Duration.ofSeconds(10));

        // ასერტი, რომ შეტყობინება სინამდვილეში გამოჩნდა
        Assert.assertTrue(notificationPanel.isDisplayed(), "შეტყობინება არ ჩანს.");
    }

    public void checkCardUnblock(){
        cardUnlockButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        cardBlockButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        Assert.assertTrue(cardBlockButton.isDisplayed(), "cardBlockButton არ ჩანს");

    }


}
