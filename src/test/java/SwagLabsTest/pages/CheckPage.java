package SwagLabsTest.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckPage {


    //Нажатие на кнопку корзины
    public CheckPage OpenCheckout() {
        $("#shopping_cart_container").click();

        return this;
    }
    //Проверка наличия товара в корзине
    public CheckPage CheckItem() {
        $(".cart_item").should(exist);

        return this;
    }
    //Клик на кнопку чекаута
    public CheckPage CheckoutClick() {
        $("#checkout").click();


        return this;
    }

    // Клик на кнопку продолжить
    public CheckPage ContinueClick() {
//        $(By.id("continue")).click();
        $("[id='continue']").click();

        return this;
    }

    public CheckPage checkoutNotification(String value) {
        $("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3").shouldHave(text(value));
        return this;

    }
}
