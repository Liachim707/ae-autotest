import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AeShoppingTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 160000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void addProductToCart() {

        // Переход на сайт с товаром
        open("https://www.ae.com/us/en/p/women/jeans/flare-bootcut-jeans/ae-super-low-rise-kick-boot-jean/1437_6248_896");

        // Кликнуть по кнопке Size
        $(".dropdown-text").click();

        // Выбор размера 000 Short
        $(".sku-size").click();

        // Добавить товар в корзину
        $("._btn-add-to-bag-suffix_xsiwrr").click();

        // Переходим в корзину
        $$("a, button")
                .filterBy(text("View Bag"))
                .first()
                .click();

        // Проверка окна оплаты PayPal
        $(".paypal-button-label-container").click();
    }
}