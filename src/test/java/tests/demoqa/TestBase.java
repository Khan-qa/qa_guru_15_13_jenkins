package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

public class TestBase {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize");
        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
