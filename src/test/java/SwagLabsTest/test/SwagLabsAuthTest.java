package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


public class SwagLabsAuthTest extends TestBase {


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
        // Открытие страницы и заполнение не валдиными значениями
        authPage.openPage()
                .setName("Dim", "Vit")
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
        // Открытие страницы и успешная авторизация
        authPage.AccessAuthWithConfig()
                .checkAuthResult("Swag Labs");


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Логаут")
    void SwagLabsLogoutTest() {

        // Открытие страницы и успешная авторизация
        authPage.AccessAuthWithConfig()
                .OpenBurger()
                .Logout();


    }
}
