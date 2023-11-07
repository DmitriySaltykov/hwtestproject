package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class SwagLabsAuthTest extends TestBase {


    AuthPage authPage = new AuthPage();

    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Проверка наличия нотификации при не заполненных полях авторизации")
    void SwagLabsTest() {
        step("Открытие страницы", () -> {
        authPage.openPage()
                .clickButton();
        });
        step("Проверка наличия нотификации при не заполненных обязательных полях", () -> {
            authPage
                .checkResult("pic sadface: Username is required");
        });
    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Проверка наличия нотификации при не валидных данных")
    void SwagLabsELogTest() {
        step("Открытие страницы", () -> {
        authPage.openPage();
        });
        step("Установка не валидных значений", () -> {
            authPage
                .setName("Dim", "Vit")
                .clickButton();
        });
        step("Проверка наличия нотификации", () -> {
            authPage
                .checkResult("Epic sadface: Username and password do not match any user in this service");
        });
    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Успешная авторизация")
    void SwagLabsLogTest() {
        // Открытие страницы и успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
        authPage.AccessAuthWithConfig()
                .checkAuthResult("Swag Labs");
        });


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Логаут")
    void SwagLabsLogoutTest() {

        // Открытие страницы и успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
        authPage.AccessAuthWithConfig()
                .OpenBurger();
        });
            step("Логаут", () -> {
                authPage
                .Logout();
        });

    }
}
