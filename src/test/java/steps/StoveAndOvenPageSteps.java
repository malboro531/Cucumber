package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.StoveAndOvenPage;

public class StoveAndOvenPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StoveAndOvenPageSteps.class);

    // Страница "Плиты и печи"
    private StoveAndOvenPage stovesAndOvensPage;

    @Дано("Открыта страница Плиты и печи")
    public void openStoveAndOvenPage() {
        // ***** Страница "Плиты и печи" *****
        stovesAndOvensPage = new StoveAndOvenPage(web.drivers.WebDriverFactory.getCurrentDriver());
    }

    @Когда("Выполнен переход на страницу Плиты электрические")
    //Перейти по ссылке Плиты электрические
    public void goToElectricStovePage() {
        // Клик по элементу
        stovesAndOvensPage.linkElectricStove().click();
        logger.info("Открыта страница [Плиты электрические]");
    }

}