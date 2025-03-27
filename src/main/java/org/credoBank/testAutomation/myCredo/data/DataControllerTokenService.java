package org.credoBank.testAutomation.myCredo.data;

import com.codeborne.selenide.Selenide;
import lombok.Getter;
import lombok.Setter;


public class DataControllerTokenService {
    @Getter // ავტომატურად გენერირებს getToken() მეთოდს
    @Setter
    private String token;

    public DataControllerTokenService getBearerToken() {
        // ტოკენის მიღება sessionStorage-დან
        String fullToken = Selenide.executeJavaScript("return sessionStorage.getItem('token');");

        if (fullToken != null && fullToken.startsWith("Bearer ")) {
            // Bearer პრეფიქსის ამოღება
            token = fullToken.split(" ")[1];
            System.out.println("Extracted Token: " + token);
        } else {
            System.out.println("Token not found or in an unexpected format!");
        }

        return this;
    }

}
