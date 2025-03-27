package org.credoBank.testAutomation.myCredo.stepsSelenide;
import org.credoBank.testAutomation.myCredo.elementsSelenide.DownloadingRequisitesElements;
import java.io.File;
import com.codeborne.selenide.Configuration;



public class DownloadingRequisitesSteps extends DownloadingRequisitesElements {

    public void clickDownloadButton(){
        downloadButton.click();
    }

        public boolean checkFileExistence() {
            // დავაყენეთ მაქსიმალური დროის ლიმიტი (10 წამი)
            long timeoutMillis = 10_000;
            long startTime = System.currentTimeMillis();

            // მივიღოთ downloads ფოლდერის მისამართი
            File folder = new File(Configuration.downloadsFolder);

            // მოვძებნოთ ფაილი 10 წამის განმავლობაში
            while (System.currentTimeMillis() - startTime < timeoutMillis) {
                // ვიპოვოთ ყველა ფაილი რომელიც იწყება "Requisites"-ით
                File[] foundFiles = folder.listFiles((dir, name) -> name.startsWith("Requisites"));

                // თუ მაინც ერთი ფაილი მოიძებნა
                if (foundFiles != null && foundFiles.length > 0) {
                    return true;
                }

                }
            // თუ 10 წამში ვერაფერი მოიძებნა
            return false;
        }
    }


