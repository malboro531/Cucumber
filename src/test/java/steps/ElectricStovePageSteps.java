package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.pages.ElectricStovePage;

public class ElectricStovePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(ElectricStovePageSteps.class);

    // Страница "Плиты электрические"
    private ElectricStovePage electricStovePage;

    @Дано("Открыта страница Электрические плиты")
    public void ElectricStovePage() {
        electricStovePage = new ElectricStovePage(web.drivers.WebDriverFactory.getCurrentDriver());
    }

    @Тогда("Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100")
    //Проверить, что в тексте Плиты электрические [количество] товаров количество товаров больше 100
    public void isCountElectricStoveOverOneHundred() {
        Assertions.assertTrue(Integer.parseInt(electricStovePage.intCountElectricStove()) > 100,
                "ERROR! Количество электрических плит меньше 100");
        logger.info("Все ОК! Количество электрических плит больше 100");
    }

}