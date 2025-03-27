package org.credoBank.testAutomation.myCredo.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;


public class SetUp {
    public static JavascriptExecutor js;
    public static  Actions actions;

    public static WebDriver driver;
    public static WebDriverWait globalWait;

    public static void SetUpGlobalWait(){

        globalWait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // ფაილების ავტომატური ჩამოტვირთვის პერმისიები
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", new File("C:/Users/narestakian/Desktop/MyCredo_NinoArestakian/downloads").getAbsolutePath());
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", chromePrefs);

        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.downloadsFolder = new File("C:/Users/narestakian/Desktop/MyCredo_NinoArestakian/downloads").getAbsolutePath();


        Configuration.fileDownload = FileDownloadMode.FOLDER;

        js = (JavascriptExecutor) driver;
        SetUpGlobalWait();
    }

    @AfterClass
    public void cleanupDownloads() throws IOException {
        // დასუფთავება ყველა ჩამოტვირთული ფაილის
        FileUtils.cleanDirectory(new File(Configuration.downloadsFolder));
        System.out.println("Download დირექტორია გასუფთავებულია");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}