package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;
import SwagLabsTest.pages.CartPage;
import SwagLabsTest.pages.CheckPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CheckoutTest {
    AuthPage authPage = new AuthPage();
    CartPage cartPage = new CartPage();
    CheckPage checkPage = new CheckPage();

    @Test
    @DisplayName("Переход на страницу корзины")
    void SwagLabsCheckoutTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem();



    }

    @Test
    @DisplayName("Переход на страницу оплаты")
    void SwagLabsGoRoPayest() {

        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem()
                .CheckoutClick();


    }

    @Test
    @DisplayName("Оформление заказа, проверка нотификации при не заполненных полях")
    void SwagLabsCreatOrderTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem()
                .ContinueClick()
                .checkoutNotification("Error: First Name is required");



    }


}
