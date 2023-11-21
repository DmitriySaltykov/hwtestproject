package swagLabsTest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SortingPage {
    SelenideElement fasetinput = $("[data-test='product_sort_container']"),
            checkfasetresult = $("[data-test='product_sort_container']");
    public SortingPage fasetInput() {
        fasetinput.click();

        return this;
    }

    public void checkFasetResult(String value) {

        checkfasetresult.shouldHave(text(value));


    }
}
