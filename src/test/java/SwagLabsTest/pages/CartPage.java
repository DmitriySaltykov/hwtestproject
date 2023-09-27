package SwagLabsTest.pages;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {


    // Добавление товара в корзину
    public CartPage addToCart() {
        $(".btn_primary").click();
        return this;

    }

    public CartPage CheckText() {
        $(".shopping_cart_badge").shouldNotBe(empty);

        return this;
    }
    //Клик по картчоке товара
    public CartPage inventoryClick() {
        $(".inventory_item_img").click();

        return this;
    }

    // Проверка заполнения полей с информацие о товаре
    public CartPage CheckDetails() {
        $(".inventory_details_name").shouldNotBe(empty);
        $(".inventory_details_desc").shouldNotBe(empty);
        $(".inventory_details_price").shouldNotBe(empty);
        return this;

    }

    //Проверка текста в кнопке
    public CartPage CheckBtn() {
        $(".btn_primary").shouldHave(text("ADD TO CART"));

        return this;
    }

    public CartPage CheckBtnRemove() {
        $(".btn_primary").shouldHave(text("Remove"));

        return this;
    }
}
