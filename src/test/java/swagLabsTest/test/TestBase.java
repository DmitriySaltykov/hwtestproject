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
    public static void beforeAll() {
        WebConfigProject webConfigProject = new WebConfigProject(config);
        webConfigProject.webConfig();
    }

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



}
