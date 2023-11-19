package swagLabsTest.test;

import swagLabsTest.config.ConfigReader;
import swagLabsTest.config.WebConfig;
import swagLabsTest.config.WebConfigProject;
import swagLabsTest.helpers.Attach;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    private static final WebConfig config = ConfigReader.Instance.read();
    @BeforeAll
    public static void beforeAll(){
        WebConfigProject webConfigProject = new WebConfigProject(config);
        webConfigProject.webConfig();}
    @BeforeEach
    void adddListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }

//    @BeforeAll
//    static void beforeAll() {
//
//        Configuration.browserSize = System.getProperty("browserSize");
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("browserVersion");
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.remote = System.getProperty("remoteDriverUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;
//    }


}