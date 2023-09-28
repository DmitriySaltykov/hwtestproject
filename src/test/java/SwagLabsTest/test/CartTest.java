package SwagLabsTest.test;

import SwagLabsTest.pages.AuthPage;

import SwagLabsTest.pages.CartPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CartTest  extends  TestBase{
    public void CartTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    AuthPage authPage = new AuthPage();
    CartPage cartPage = new CartPage();


    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Добавление товара в корзину и проверка счетчика")
    void SwagLabsAddTest() {
        authPage.AccessAuthWithConfig();
        cartPage.addToCart()
                .CheckText();


    }
    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Переход на PDP товара и проверка заполнение  картчоки товара")
    void SwagLabsPDPTest() {

        // Открытие страницы,успешная авторизация
        authPage.AccessAuthWithConfig();
        cartPage.inventoryClick()
                .CheckDetails()
                .CheckBtn();


    }

    @Test
    @Tags({
            @Tag("web"),
            @Tag("cart")
    })
    @DisplayName("Переход на PDP добавленного товара  и проверка заполнение картчоки товара")
    void SwagLabsAddedPDPTest() {
        authPage.AccessAuthWithConfig();
        cartPage.addToCart()
                .inventoryClick()
                .CheckDetails()
                .CheckBtnRemove();


    }

}
