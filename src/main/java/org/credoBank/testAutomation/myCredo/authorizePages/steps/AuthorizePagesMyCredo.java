package org.credoBank.testAutomation.myCredo.authorizePages.steps;
import com.codeborne.selenide.Condition;
import org.credoBank.testAutomation.myCredo.elementsSelenide.MyCredoAuthorizationElements;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizePagesMyCredo extends MyCredoAuthorizationElements {

    public void openMyCredoPage() {
        open("https://testmycredo.credo.ge/landing/main/auth");
    }

    public void checkSubmitButtonIsDisabled() {
        submitButton.shouldBe(Condition.disabled).shouldNotBe(Condition.clickable);
    }

    public void authorize(String userNameValue, String passwordValue) {
        userName.setValue(userNameValue);
        password.setValue(passwordValue);
        submitButton.click();
    }

    public void checkSubmitButtonIsEnable() {
        submitButton.shouldBe(Condition.enabled).shouldBe(Condition.clickable);
    }

    public void checkOtpSubmitButtonIsDisabled() {
        otpSubmitButton.shouldBe(Condition.disabled).shouldNotBe(Condition.clickable);

    }


    public void setOtp(String otpCodeValue) {
        otpInput.setValue(otpCodeValue);
        otpSubmitButton.click();

        }
    public void clickEasyAuthCloseButtonIfPresent() {
        if (!easyAuthCloseButton.isEmpty() && easyAuthCloseButton.get(2).isDisplayed()) {
            easyAuthCloseButton.get(2).click();
        } else {
            System.out.println("მარტივი ავტორიზაციის PopUp არ გამოვიდა.");
        }
    }

    }



