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

import static io.qameta.allure.Allure.step;

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
        step("Открытие страницы и успешная авторизация", () -> {
        authPage
                .AccessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });
        step("Открытие страницы чекаута и проверка наличия добавленного товара ", () -> {
        checkPage.OpenCheckout()
                .CheckItem();
        });


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Переход на страницу оплаты")
    void SwagLabsGoRoPayest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .AccessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });

        step("Открытие страницы чекаута и переход на страницу оплаты ", () -> {
        checkPage.OpenCheckout()
                .CheckItem()
                .CheckoutClick();
        });


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Оформление заказа, проверка нотификации при не заполненных полях")
    void SwagLabsCreatOrderCheckNotificationTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .AccessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });
        step("Проверка нотификации на странице чекаута при не заполненых полях ", () -> {
        checkPage.OpenCheckout()
                .CheckItem()
                .CheckoutClick()
                .ContinueClick()
                .checkoutNotification("Error: First Name is required");
        });


    }
    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Оформление заказа, проверка нотификации при успешном оформлении заказа")
    void SucsessCreatOrderTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .AccessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });
        step("Переход на страницу оплаты  ", () -> {
        checkPage.OpenCheckout()
                .CheckItem();
        });
        step("Заполнение обязательных полей и оформление заказа ", () -> {
            checkPage
                .CheckoutClick()
                .AccessClientInfo()
                .ContinueClick()
                .FinishClick();
        });
        step("Проверка наличия нотификации об успешном оформлении заказа", () -> {
            checkPage
                .FinalSucsessNotification("Thank you for your order!");
        });




    }


}
