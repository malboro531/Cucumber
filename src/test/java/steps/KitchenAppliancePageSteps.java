package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import web.pages.KitchenAppliancePage;

public class KitchenAppliancePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(KitchenAppliancePageSteps.class);

    // Страница "Техника для кухни"
    private KitchenAppliancePage kitchenAppliancePage;

    @Дано("Открыта страница Техника для кухни")
    public void openKitchenAppliancePage() {
        kitchenAppliancePage = new KitchenAppliancePage(web.drivers.WebDriverFactory.getCurrentDriver());
    }

    @Тогда("Вывести в логи названия всех категорий")
    //Вывести в логи названия всех категорий
    public void getLogsCategories() {
        for (WebElement category : kitchenAppliancePage.kitchenCategories()) {
            String categoryName = category.getText();
            logger.info(categoryName);
        }
    }

    @И("Проверить, что отображается текст Техника для кухни")
    //Проверить, что отображается текст Техника для кухни
    public void pageTitleEqualsKitchenAppliance() {
        String expected = "Техника для кухни";
        String actual = kitchenAppliancePage.linkKitchenAppliance().getText();
        Assertions.assertEquals(expected, actual, "ERROR! Текст Техника для кухни не отображается!");
        logger.info("Все ОК! Текст Техника для кухни отображается");
    }

    @И("Проверить, что количество категорий больше 5")
    //Проверить, что количество категорий больше 5
    public void isCountKitchenCategoriesOverFive() {
        Assertions.assertTrue(kitchenAppliancePage.kitchenCategories().size() > 5,
                "ERROR! Количество категорий меньше 5");
        logger.info("Все ОК! Количество категорий больше 5");
    }

    @И("Проверить, что отображается ссылка Собрать свою кухню")
    //Проверить, что отображается ссылка Собрать свою кухню
    public void isDisplayedLinkAssembleKitchen() {
        Assertions.assertTrue(kitchenAppliancePage.linkAssembleKitchen().getWebElement().isDisplayed(),
                "ERROR! Ссылка Собрать свою кухню не отображается!");
        logger.info("Все ОК! Ссылка Собрать свою кухню отображается");
    }

}