package SwagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthPage {

    SelenideElement firstNameInput = $("#user-name"),
            lastNameInput = $("#password"),
            loginbutton = $("#login-button");


    public AuthPage openPage() {
        open("https://www.saucedemo.com/");

        return this;
    }

    public AuthPage AccessAuth() {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        loginbutton.click();

        return this;
    }

    public AuthPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public AuthPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public AuthPage clickButton() {
        loginbutton.click();

        return this;
    }

    public void checkResult(String value) {
        $("#login_button_container > div > form > div.error-message-container.error").shouldHave(text(value));


    }

    public void checkAuthResult(String value) {
        $(".app_logo").shouldBe(visible);

    }
    // Добавление товара в корзину
    public AuthPage addToCart() {
        $(".btn_primary").click();
        return this;

    }

    public AuthPage CheckText() {
        $(".shopping_cart_badge").shouldNotBe(empty);

        return this;
    }
//Клик по картчоке товара
    public AuthPage inventoryClick() {
        $(".inventory_item_img").click();

        return this;
    }
    // Проверка заполнения полей с информацие о товаре
    public AuthPage CheckDetails() {
        $(".inventory_details_name").shouldNotBe(empty);
        $(".inventory_details_desc").shouldNotBe(empty);
        $(".inventory_details_price").shouldNotBe(empty);
        return this;

    }
    //Проверка текста в кнопке
    public AuthPage CheckBtn() {
        $(".btn_primary").shouldHave(text("ADD TO CART"));

        return this;
    }
    public AuthPage CheckBtnRemove() {
        $(".btn_primary").shouldHave(text("Remove"));

        return this;
    }
    //Раскрытие бургера-меню
    public AuthPage OpenBurger() {
        $(".bm-burger-button").click();

        return this;
    }
    //Нажатие на кнопку логаут
    public AuthPage Logout() {
        $("#logout_sidebar_link").click();

        return this;
    }


     static final String CONFIG_FILE = "config.properties";
    private Properties loadConfig() {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
    public AuthPage AccessAuthWithConfig() {
        Properties properties = loadConfig();

        open("https://www.saucedemo.com/");
        $("#user-name").setValue(properties.getProperty("username"));
        $("#password").setValue(properties.getProperty("password"));
        loginbutton.click();

        return this;
    }

    //Нажатие на кнопку корзины
    public AuthPage OpenCheckout() {
        $("#shopping_cart_container").click();

        return this;
    }

        //Проверка наличия товара в корзине
    public AuthPage CheckItem() {
        $(".cart_item").should(exist);

        return this;
    }
}
