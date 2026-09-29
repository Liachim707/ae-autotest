import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AeShoppingTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    void addProductToCart() {

        // Переход на сайт с товаром
        open("https://clck.su/wbqJW");

        // Кликнуть по кнопке Size
        $("dropdown-text").click();

        // Добавляем товар
        $$("button")
                .filterBy(text("Add to Bag(Before It's Gone)"))
                .first()
                .shouldBe(visible)
                .click();

        // Переходим в корзину
        $$("a, button")
                .filterBy(text("Bag"))
                .first()
                .click();

        // Проверяем корзину
        $("body")
                .shouldHave(text("Bag"));
    }
}