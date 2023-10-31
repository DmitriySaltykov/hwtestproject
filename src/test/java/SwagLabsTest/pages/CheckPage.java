package SwagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static SwagLabsTest.pages.AuthPage.CONFIG_FILE;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckPage {
    SelenideElement shopingicon = $("#shopping_cart_container"),
            cartitem = $(".cart_item"),
            checkoutbtn = $("#checkout"),
            craatorder = $("#continue"),
            checkoutnotification = $("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error"),

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



    public CheckPage FinishClick() {
        finishbutton.click();


        return this;
    }
    public CheckPage FinalSucsessNotification(String value) {
        finalnotification.shouldHave(text(value));
        return this;

    }
    private Properties loadConfig() {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
    public CheckPage AccessClientInfo() {
        Properties properties = loadConfig();

                $("#first-name").setValue(properties.getProperty("firstname"));
        $("#last-name").setValue(properties.getProperty("lastname"));
        $("#postal-code").setValue(properties.getProperty("zipcode"));

        return this;
    }

}
