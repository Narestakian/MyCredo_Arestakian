package org.credoBank.testAutomation.myCredo.elementsSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyCredoProductsElements {
    public SelenideElement productsButton = $x("//a[contains(@routerlink, '/home/products')]//p[text()='პროდუქტები']");
    public SelenideElement dropDownElement =  $x("//div[@class='header trigger']/p[@_ngcontent-ng-c2345056869 and contains(text(), '₾')]");

}
