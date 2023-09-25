//package SwagLabsTest.test;
//
//import SwagLabsTest.pages.AuthPage;
//import org.checkerframework.checker.units.qual.A;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.closeWebDriver;
//
//public class CartTest {
//    AuthPage authPage = new AuthPage();
//
//
//    @Test
//    @DisplayName("Добавление товара в корзину и проверка счетчика")
//    void SwagLabsAddTest() {
//        authPage.AccessAuthWithConfig()
//                .addToCart()
//                .CheckText();
//        // Закрытие браузера
//        closeWebDriver();
//
//    }
////    @Test
////    @DisplayName("Переход на PDP товара и проверка заполнение  картчоки товара")
////    void SwagLabsPDPTest() {
////
////        // Открытие страницы,успешная авторизация
////        authPage.AccessAuthWithConfig()
////                .inventoryClick()
////                .CheckDetails()
////                .CheckBtn();
////        // Закрытие браузера
////        closeWebDriver();
////
////    }
//
//    @Test
//    @DisplayName("Переход на PDP добавленного товара  и проверка заполнение картчоки товара")
//    void SwagLabsAddedPDPTest() {
//        authPage.AccessAuthWithConfig()
//                .addToCart()
//                .inventoryClick()
//                .CheckDetails()
//                .CheckBtnRemove();
//        // Закрытие браузера
//        closeWebDriver();
//
//    }
//
//}
