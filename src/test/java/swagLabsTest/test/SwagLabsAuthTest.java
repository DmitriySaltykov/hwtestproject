package swagLabsTest.test;

import swagLabsTest.pages.AuthPage;
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
    void swagLabsTest() {
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
    void swagLabsELogTest() {
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
    void swagLabsLogTest() {
        // Открытие страницы и успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage.accessAuthWithConfig()
                    .checkAuthResult("Swag Labs");
        });


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("login"),
    })
    @DisplayName("Логаут")
    void swagLabsLogoutTest() {

        // Открытие страницы и успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage.accessAuthWithConfig()
                    .OpenBurger();
        });
        step("Логаут", () -> {
            authPage
                    .logout();
            step("Поверка на отображения интерфейса для не авторизованного пользователя ", () -> {
                authPage
                    .checkLogoutResult("Accepted usernames are:");
        });

    }
}
