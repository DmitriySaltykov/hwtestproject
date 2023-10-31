package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;
import SwagLabsTest.pages.CartPage;
import SwagLabsTest.pages.CheckPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends TestBase {



    AuthPage authPage = new AuthPage();
    CartPage cartPage = new CartPage();
    CheckPage checkPage = new CheckPage();

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Переход на страницу корзины")
    void SwagLabsCheckoutTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem();


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Переход на страницу оплаты")
    void SwagLabsGoRoPayest() {

        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem()
                .CheckoutClick();


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Оформление заказа, проверка нотификации при не заполненных полях")
    void SwagLabsCreatOrderCheckNotificationTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem()
                .CheckoutClick()
                .ContinueClick()
                .checkoutNotification("Error: First Name is required");


    }
    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Оформление заказа, проверка нотификации при успешном оформлении заказа")
    void SucsessCreatOrderTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.addToCart();
        checkPage.OpenCheckout()
                .CheckItem()
                .CheckoutClick()
                .AccessClientInfo()
                .ContinueClick()
                .FinishClick()
                .FinalSucsessNotification("Thank you for your order!");




    }


}
