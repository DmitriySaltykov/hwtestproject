package swagLabsTest.test;

import swagLabsTest.pages.AuthPage;
import swagLabsTest.pages.CartPage;
import swagLabsTest.pages.CheckPage;
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
    void swagLabsCheckoutTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
        authPage
                .accessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });
        step("Открытие страницы чекаута и проверка наличия добавленного товара ", () -> {
        checkPage.openCheckout()
                .checkItem();
        });


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Переход на страницу оплаты")
    void swagLabsGoRoPayest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .accessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });

        step("Открытие страницы чекаута и переход на страницу оплаты ", () -> {
        checkPage.openCheckout()
                .checkItem()
                .checkoutClick();
        });


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Оформление заказа, проверка нотификации при не заполненных полях")
    void swagLabsCreatOrderCheckNotificationTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .accessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });
        step("Проверка нотификации на странице чекаута при не заполненых полях ", () -> {
        checkPage.openCheckout()
                .checkItem()
                .checkoutClick()
                .continueClick()
                .checkoutNotification("Error: First Name is required");
        });


    }
    @Test
    @Tags({
            @Tag("web"),
            @Tag("checkout")
    })
    @DisplayName("Оформление заказа, проверка нотификации при успешном оформлении заказа")
    void sucsessCreatOrderTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .accessAuthWithConfig();
        });

        step("Добавление товара в корзину ", () -> {
            cartPage.addToCart();
        });
        step("Переход на страницу оплаты  ", () -> {
        checkPage.openCheckout()
                .checkItem();
        });
        step("Заполнение обязательных полей и оформление заказа ", () -> {
            checkPage
                .checkoutClick()
                .accessClientInfo()
                .continueClick()
                .finishClick();
        });
        step("Проверка наличия нотификации об успешном оформлении заказа", () -> {
            checkPage
                .finalSucsessNotification("Thank you for your order!");
        });




    }


}
