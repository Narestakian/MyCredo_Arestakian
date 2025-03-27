package org.credoBank.testAutomation.myCredo.stepsSelenide;
import com.codeborne.selenide.Condition;
import org.credoBank.testAutomation.myCredo.elementsSelenide.TransferFromAccountElements;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;



public class TransferFromAccountSteps extends TransferFromAccountElements {
    public void transferButtonClick(){
        transferButton.click();
        webdriver().shouldHave(url("https://testmycredo.credo.ge/home/financial-operations/transfers"));

    }


    public void checkTransferHeader(){
        transferHeader.shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollIntoView(true);
        transferHeader.shouldHave(Condition.text("გადარიცხვა"));
    }

}
