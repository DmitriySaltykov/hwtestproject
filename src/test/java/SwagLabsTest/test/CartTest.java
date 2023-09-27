package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;

import SwagLabsTest.pages.CartPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CartTest {
    AuthPage authPage = new AuthPage();
    CartPage cartPage = new CartPage();


    @Test
    @DisplayName("Добавление товара в корзину и проверка счетчика")
    void SwagLabsAddTest() {
        authPage.AccessAuthWithConfig();
        cartPage.addToCart()
                .CheckText();


    }
    @Test
    @DisplayName("Переход на PDP товара и проверка заполнение  картчоки товара")
    void SwagLabsPDPTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.inventoryClick()
                .CheckDetails()
                .CheckBtn();


    }

    @Test
    @DisplayName("Переход на PDP добавленного товара  и проверка заполнение картчоки товара")
    void SwagLabsAddedPDPTest() {
        authPage.AccessAuthWithConfig();
        cartPage.addToCart()
                .inventoryClick()
                .CheckDetails()
                .CheckBtnRemove();


    }

}
