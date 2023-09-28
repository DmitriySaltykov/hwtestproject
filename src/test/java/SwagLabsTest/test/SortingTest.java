package SwagLabsTest.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SortingTest extends TestBase {


    public void SortingTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Tags({
            @Tag("web"),
            @Tag("fasets")
    })
    @DisplayName("Проверка наличия сортировки на странице с товарами ")
    @CsvSource(value = {
            "az, Name (A to Z)",
            "za, Name (Z to A)",
            "lohi, Price (low to high)",
            "hilo, Price (high to low)"
    })

    @ParameterizedTest(name = "Товары на странице сортируются в соответствии с выбраннм фильтром \"{1}\" .")
    void SortingTest(String testData, String expectedResult) {

        open("https://www.saucedemo.com/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $("[data-test='product_sort_container']").selectOptionByValue((testData));
        $("[data-test='product_sort_container']").shouldHave(text(expectedResult));


    }

}
