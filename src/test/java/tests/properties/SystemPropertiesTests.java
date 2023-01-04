package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simplePropertyOneTest() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // opera
    }


    @Test
    void simplePropertyTwoTest() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // firefox
    }

    @Test
    void simplePropertyThreeTest() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // opera
    }

    @Test
    @Tag("one_property_test")
    void simplePropertyFourTest() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
        // gradle clean one_property -Dbrowser=safari
        // safari
    }

    @Test
    @Tag("many_properties_test")
    void simplePropertyFiveTest() {
        String browserName = System.getProperty("browser", "firefox");
        String browserVersion = System.getProperty("browser_version", "105");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

    @Test
    @Tag("hello")
    void simplePropertySixTest() {
        System.out.println("Hello, " + System.getProperty("user_name", "unknown student"));
    }
}

