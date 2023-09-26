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

                authPage.AccessAuthWithConfig()
                .addToCart()
                .OpenCheckout()
                .CheckItem()
                .CheckoutClick();

        // Закрытие браузера
        closeWebDriver();

    }

    @Test
    @DisplayName("Оформление заказа, проверка нотификации при не заполненных полях")
    void SwagLabsCreatOrderTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig()
                .addToCart()
                .OpenCheckout()
                .CheckItem()

                .ContinueClick()
                .checkoutNotification("Error: First Name is required");

        // Закрытие браузера
        closeWebDriver();

    }


}
