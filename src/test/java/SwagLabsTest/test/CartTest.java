package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;

import SwagLabsTest.pages.CartPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
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
    void SwagLabsAddTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .AccessAuthWithConfig();
        });

        step("Добавление товара в корзину и проверка изменения счетчика корзины", () -> {
            cartPage.addToCart()
            .CheckText();
        });

    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Переход на PDP товара и проверка заполнение  картчоки товара")
    void SwagLabsPDPTest() {

        // Открытие страницы,успешная авторизация
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .AccessAuthWithConfig();
        });
        step("Переход на карточку товара и проверка заполнения полей с информацие о товаре", () -> {
        cartPage.inventoryClick()
                .CheckDetails()
                .CheckBtn();
        });
    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Переход на PDP добавленного товара  и удаление  добавленного товара")
    void SwagLabsAddedPDPTest() {
        step("Открытие страницы и успешная авторизация", () -> {
            authPage
                    .AccessAuthWithConfig();
        });
        step("Переход на карточку товара и проверка заполнения полей с информацие о товаре", () -> {
        cartPage.addToCart()
                .inventoryClick()
                .CheckDetails();
        });
        step("Удаление товара из корзины ", () -> {
            cartPage
                    .CheckBtnRemove();
        });

    }

}
