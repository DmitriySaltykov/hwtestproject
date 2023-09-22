package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SwagLabsTest {
 AuthPage authPage = new AuthPage();
@Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
               })
    @DisplayName("Проверка наличия нотификации при не заполненных полях авторизации")
        void SwagLabsTest() {
    authPage.openPage()
            .clickButton()
           .checkResult("pic sadface: Username is required");
}
    @Test
        @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Проверка наличия нотификации при не валидных данных")
    void SwagLabsELogTest() {

        authPage.openPage()
        .setFirstName("Dim")
        .setLastName("Vit")
        .clickButton()
        .checkResult("Epic sadface: Username and password do not match any user in this service");

    }
    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Успешная авторизация")
    void SwagLabsLogTest() {

        authPage.openPage();
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        authPage.clickButton();
        $("#header_container > div.primary_header > div.header_label").shouldHave(text("Swag Labs"));

    }
}
