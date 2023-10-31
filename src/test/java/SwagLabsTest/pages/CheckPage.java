package SwagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckPage {
    SelenideElement shopingicon = $("#shopping_cart_container"),
            cartitem = $(".cart_item"),
            checkoutbtn = $("#checkout"),
            craatorder = $("#continue"),
            checkoutnotification = $("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error"),

    firstNameInput = $("#first-name"),
    lastNameInput = $("#last-name"),
    zipInput = $("#postal-code"),
    finishbutton = $("#finish"),
    finalnotification = $("#checkout_complete_container");
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


        return this;
    }

    public CheckPage checkoutNotification(String value) {
        checkoutnotification.shouldHave(text(value));
        return this;

    }

    public CheckPage setName(String firstName, String lastname,String zip) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastname);
        zipInput.setValue(zip);


        return this;
    }

    public CheckPage FinishClick() {
        finishbutton.click();


        return this;
    }
    public CheckPage FinalSucsessNotification(String value) {
        finalnotification.shouldHave(text(value));
        return this;

    }

}
