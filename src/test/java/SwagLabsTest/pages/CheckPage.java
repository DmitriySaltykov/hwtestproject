package SwagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckPage {
    SelenideElement shopingicon = $("#shopping_cart_container"),
            cartitem = $(".cart_item"),
            checkoutbtn = $("#checkout"),
            craatorder = $("#continue"),
            checkoutnotification = $("error-message-container error");


    //Нажатие на кнопку корзины
    public CheckPage OpenCheckout() {
        shopingicon.click();

        return this;
    }

    //Проверка наличия товара в корзине
    public CheckPage CheckItem() {
        cartitem.should(exist);

        return this;
    }

    //Клик на кнопку чекаута
    public CheckPage CheckoutClick() {
        checkoutbtn.click();


        return this;
    }

    // Клик на кнопку продолжить
    public CheckPage ContinueClick() {
        craatorder.click();
        // $("[id='continue']").click();

        return this;
    }

    public CheckPage checkoutNotification(String value) {
        checkoutnotification.shouldHave(text(value));
        return this;

    }
}
