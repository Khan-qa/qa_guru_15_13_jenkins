package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    /*
    * {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browserSize");
        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    } */

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browser = System.getProperty("browser", "chrome");
        System.out.println(Configuration.browser);
        Configuration.browserVersion = System.getProperty("browser_version", "100");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        Configuration.baseUrl = "https://demoqa.com";


        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;*/
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
