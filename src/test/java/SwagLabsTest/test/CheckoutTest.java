package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CheckoutTest {
    AuthPage authPage = new AuthPage();

    @Test
    @DisplayName("Переход на страницу корзины")
    void SwagLabsCheckoutTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig()
                .addToCart()
                .OpenCheckout()
                .CheckItem();

        // Закрытие браузера
        closeWebDriver();

    }
    @Test
    @DisplayName("Переход на страницу оплаты")
    void SwagLabsGoRoPayest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig()
                .addToCart()
                .OpenCheckout()
                .CheckItem()
                .ChecoutClick();

        // Закрытие браузера
        closeWebDriver();

    }

}
