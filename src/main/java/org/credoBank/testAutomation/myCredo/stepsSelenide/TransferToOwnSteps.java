package org.credoBank.testAutomation.myCredo.stepsSelenide;
import com.codeborne.selenide.Condition;
import org.credoBank.testAutomation.myCredo.elementsSelenide.TransferToOwnAccountElements;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.actions;


public class TransferToOwnSteps extends TransferToOwnAccountElements {

    public void clickTransferToOwnAccount(){
        actions().moveToElement(transferToOwnAccountElement).click().perform();
        accountToElement.shouldBe(Condition.visible, Duration.ofSeconds(10));

    }


    public void clickAccountTo(){
        accountToElement.click();

    }

    public void clickCurrentAccount(){
        currentAccountElement.scrollTo().click();

    }

    public void clickCurrencyGel(){
        currencyGelElement.click();

    }

    public void clickAmountInput(){
        amountInputElement.click();
    }

    public void setEnterAmount( String amountValue){
        amountInputElement.setValue(amountValue);

    }

    public void clickTransferButton(){
        transferButtonElement.click();

    }

    public void checkSuccessfulTransferPopup(){
        successPopupElement.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldHave(Condition.text("გადარიცხვა წარმატებით შესრულდა"));
    }
}
