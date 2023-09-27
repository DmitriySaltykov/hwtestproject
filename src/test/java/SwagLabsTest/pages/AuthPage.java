package SwagLabsTest.pages;

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
            logout = $("#logout_sidebar_link");


    public AuthPage openPage() {
        open("https://www.saucedemo.com/");

        return this;
    }

    public AuthPage AccessAuth() {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        loginbutton.click();

        return this;
    }

    public AuthPage setName(String firstName, String lastname) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastname);


        return this;
    }

//    public AuthPage setLastName(String value) {
//        lastNameInput.setValue(value);
//
//        return this;
//    }

    public AuthPage clickButton() {
        loginbutton.click();

        return this;
    }

    public void checkResult(String value) {

        checkresultwindow.shouldHave(text(value));


    }

    public void checkAuthResult(String value) {
        $(".app_logo").shouldBe(visible);

    }

    //Раскрытие бургера-меню и логаут
    public AuthPage OpenBurger() {
        openburger.click();

        return this;
    }

    //Нажатие на кнопку логаут
    public AuthPage Logout() {
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

    public AuthPage AccessAuthWithConfig() {
        Properties properties = loadConfig();

        open("https://www.saucedemo.com/");
        $("#user-name").setValue(properties.getProperty("username"));
        $("#password").setValue(properties.getProperty("password"));
        loginbutton.click();

        return this;
    }


}
