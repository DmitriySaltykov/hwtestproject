package SwagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthPage {

    SelenideElement firstNameInput = $("#user-name"),
            lastNameInput = $("#password"),
            loginbutton=$("#login-button");




    public AuthPage openPage() {
        open("https://www.saucedemo.com/");

        return this;
    }
    public AuthPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public AuthPage setLastName(String value) {
        lastNameInput.setValue("Dim");

        return this;
    }
    public AuthPage clickButton () {
        loginbutton.click();

        return this;
    }
    public void  checkResult(String value) {
        $("#login_button_container > div > form > div.error-message-container.error").shouldHave(text(value));


    }



}
