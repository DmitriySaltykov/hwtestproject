package swagLabsTest.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import swagLabsTest.pages.AuthPage;
import swagLabsTest.pages.SortingPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SortingTest extends TestBase {
    AuthPage authPage = new AuthPage();
    SortingPage sortingPage = new SortingPage();


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
    void sortingTest(String testData, String expectedResult) {

        step("Открытие страницы и успешная авторизация", () -> {

            authPage.accessAuthWithConfig()
                    .OpenBurger();
        });

        step("Установка значения сортировки", () -> {
            sortingPage.fasetInput();
        });
        step("Проверка применения сортировки", () -> {
            sortingPage.fasetInput();
        });


    }

}
