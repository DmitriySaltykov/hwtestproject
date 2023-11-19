package swagLabsTest.test;

import swagLabsTest.pages.AuthPage;

import swagLabsTest.pages.CartPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class CartTest extends TestBase {


    AuthPage authPage = new AuthPage();
    CartPage cartPage = new CartPage();


    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Добавление товара в корзину и проверка счетчика")
    void swagLabsAddTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .accessAuthWithConfig();
        });

        step("Добавление товара в корзину и проверка изменения счетчика корзины", () -> {
            cartPage.addToCart()
            .checkText();
        });

    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Переход на PDP товара и проверка заполнение  картчоки товара")
    void swagLabsPDPTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .accessAuthWithConfig();
        });
        step("Переход на карточку товара и проверка заполнения полей с информацие о товаре", () -> {
        cartPage.inventoryClick()
                .checkDetails()
                .checkBtn();
        });
    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Переход на PDP добавленного товара  и удаление  добавленного товара")
    void swagLabsAddedPDPTest() {
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .accessAuthWithConfig();
        });
        step("Переход на карточку товара и проверка заполнения полей с информацие о товаре", () -> {
        cartPage.addToCart()
                .inventoryClick()
                .checkDetails();
        });
        step("Удаление товара из корзины ", () -> {
            cartPage
                    .checkBtnRemove();
        });

    }

}
