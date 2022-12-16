package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.AppliancePage;

public class AppliancePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(AppliancePageSteps.class);

    // Страница "Бытовая техника"
    private AppliancePage appliancePage;

    @Дано("Открыта страница Бытовая техника")
    public void openAppliancePage() {
        appliancePage = new AppliancePage(web.drivers.WebDriverFactory.getCurrentDriver());
    }

    @И("Выполнен переход на страницу Техника для кухни")
    //Перейти по ссылке Техника для кухни
    public void goToKitchenAppliancePage() {
        // Фокус на элементе
        appliancePage.linkKitchenAppliance().focusOnLink();
        // Клик по элементу
        appliancePage.linkKitchenAppliance().click();
        logger.info("Открыта страница [Техника для кухни]");
    }

    @Тогда("Проверить, что отображается текст Бытовая техника")
    //Проверить, что отображается текст Бытовая техника
    public String getApplianceTitle() {return appliancePage.linkAppliance().getText();}

}