package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.helpers.JavaScriptHelper;
import web.pages.LaptopProductPage;

public class LaptopProductPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(LaptopProductPageSteps.class);

    // Страница "Продукт. Ноутбук"
    private LaptopProductPage laptopProductPage;

    @Дано("Открыта страница Продукт. Ноутбук")
    public void LaptopProductPageSteps() {
        laptopProductPage = new LaptopProductPage(web.drivers.WebDriverFactory.getCurrentDriver());
    }

    @Когда("Развернуть список характеристик Ноутбука")
    //Развернуть список характеристик Ноутбука
    public void getAllSpecifications() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 1000);
        laptopProductPage.buttonAllSpecifications().click();
    }


    @Тогда("Проверить, что заголовок страницы соответствует ожидаемому")
    // Проверить, что заголовок страницы соответствует ожидаемому
    public void pageTitleEquals() {
        String expected = "Технические характеристики 15.6\" Ноутбук ASUS ZenBook PRO DUO 15 OLED UX582LR-H2006T" +
                " синий | 4800982 . Интернет-магазин DNS";
        String actual = laptopProductPage.getPageTitle();
        Assertions.assertEquals(expected, actual, "ERROR! Заголовок страницы не соответствует ожидаемому!");
        logger.info("Все ОК! Заголовок страницы соответствует ожидаемому");

    }

    @Тогда("Проверить, что в блоке Характеристики заголовок содержит ASUS")
    //Проверить, что в блоке Характеристики заголовок содержит ASUS
    public void chCompanyAsusEquals() {
        String actual = laptopProductPage.baseElementChCompany().getText();
        Assertions.assertTrue((actual).contains("ASUS"));
        logger.info("Все ОК! В блоке Характеристики заголовок содержит ASUS");
    }

    @Тогда("Проверить, что в блоке Характеристики значение Объем оперативной памяти равен 32 ГБ")
    //Проверить, что в блоке Характеристики значение Объем оперативной памяти равен 32 ГБ
    public void chRAMEquals() {
        String actual = laptopProductPage.baseElementChRAM().getText();
        Assertions.assertEquals("32 ГБ", actual);
        logger.info("Все ОК! В блоке Характеристики Объем оперативной памяти равен 32 ГБ");
    }

}