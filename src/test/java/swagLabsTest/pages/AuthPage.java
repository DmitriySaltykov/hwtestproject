package swagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthPage {

    SelenideElement firstNameInput = $("#user-name"),
            lastNameInput = $("#password"),
            loginbutton = $("#login-button"),
            checkresultwindow = $("#login_button_container > div > form > div.error-message-container.error"),
            openburger = $(".bm-burger-button"),
            logout = $("#logout_sidebar_link"),
            applogo = $(".app_logo");


    public AuthPage openPage() {
        open("");

        return this;
    }


    public AuthPage setName(String firstName, String lastname) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastname);


        return this;
    }

    public AuthPage clickButton() {
        loginbutton.click();

        return this;
    }

    public void checkResult(String value) {

        checkresultwindow.shouldHave(text(value));


    }

    public void checkAuthResult(String value) {
        applogo.shouldBe(visible);

    }

    //Раскрытие бургера-меню и логаут
    public AuthPage OpenBurger() {
        openburger.click();

        return this;
    }

    //Нажатие на кнопку логаут
    public AuthPage logout() {
        logout.click();

        return this;
    }


    static final String CONFIG_FILE = "config.properties";

    private Properties loadConfig() {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public AuthPage accessAuthWithConfig() {
        Properties properties = loadConfig();

        open("");
        $("#user-name").setValue(properties.getProperty("username"));
        $("#password").setValue(properties.getProperty("password"));
        loginbutton.click();

        return this;
    }


}
