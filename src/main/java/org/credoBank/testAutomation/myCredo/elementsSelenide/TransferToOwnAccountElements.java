package org.credoBank.testAutomation.myCredo.elementsSelenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferToOwnAccountElements {
public SelenideElement transferToOwnAccountElement = $x("//div[contains(@class, 'txt')]/p[contains(@class, 'paragraph-14') and text()='საკუთარ ანგარიშზე']");
public SelenideElement accountToElement = $x("//app-account-select-advanced//p[contains(text(), 'აირჩიეთ ანგარიში')]");
public SelenideElement currentAccountElement = $x("//div[contains(@class, 'header trigger')]//p[text()='მიმდინარე']");
public SelenideElement currencyGelElement = $x("//div[contains(@class, 'currency-img') and contains(@class, 'gel')]");
public SelenideElement amountInputElement = $x("//input[@name='amount']");
public SelenideElement transferButtonElement = $("button.primary.next[type='submit']");
public SelenideElement successPopupElement = $x("//div[contains(@class, 'payment-success-popup')]//p[contains(text(), 'გადარიცხვა წარმატებით შესრულდა')]");
}
