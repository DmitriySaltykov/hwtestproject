package SwagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    SelenideElement primary_btn = $(".btn_primary"),
            shopingicon = $(".shopping_cart_badge"),
            inventorylogo = $(".inventory_item_img"),
            detailsname = $(".inventory_details_name"),
            detailsdesc = $(".inventory_details_desc"),
            detailsprice = $(".inventory_details_price"),
            removebtn = $(By.id("remove-sauce-labs-backpack")),;


    // Добавление товара в корзину
    public CartPage addToCart() {
        primary_btn.click();
        return this;

    }

    public CartPage CheckText() {
        shopingicon.shouldNotBe(empty);

        return this;
    }

    //Клик по картчоке товара
    public CartPage inventoryClick() {
        inventorylogo.click();

        return this;
    }

    // Проверка заполнения полей с информацие о товаре
    public CartPage CheckDetails() {
        detailsname.shouldNotBe(empty);
        detailsdesc.shouldNotBe(empty);
        detailsprice.shouldNotBe(empty);
        return this;

    }

    //Проверка текста в кнопке
    public CartPage CheckBtn() {
        primary_btn.shouldHave(text("ADD TO CART"));

        return this;
    }

    public CartPage CheckBtnRemove() {
        removebtn.shouldHave(text("Remove"));

        return this;
    }
}
