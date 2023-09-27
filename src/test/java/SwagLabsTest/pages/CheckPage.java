package SwagLabsTest.pages;

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
        $("#continue").click();

        return this;
    }

    public CheckPage checkoutNotification(String value) {
        $("#error-message-container error").shouldHave(text(value));
        return this;

    }
}
