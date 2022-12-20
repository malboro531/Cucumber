package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Шаги на странице "Стартовая"
public class StartPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Стартовая страница сайта DNS
    private StartPage startPage;

    // Шаг: Открыта страница "Стартовая страница сайта DNS"
    @Дано("Открыта страница Стартовая страница сайта DNS")
    public void openStartPage() {
        startPage = new StartPage(web.drivers.WebDriverFactory.getCurrentDriver());
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта Стартовая страница сайта DNS");
    }

    //Закрыть окно подтверждения города
    @И("Закрыть окно подтверждения города")
    public void closeCityAgree() {
        startPage.buttonYes().click();
        logger.info("Окно подтверждения города закрыто");
    }

    // Навести курсор мыши на ссылку "Бытовая техника"
    @Когда("Навести курсор на ссылку Бытовая техника")
    public void focusOnLinkAppliance() {
        startPage.linkAppliance().focusOnLink();
    }

    @И("Навести курсор на ссылку Плиты и печи")
    //Навести курсор на ссылку Плиты и печи
    public void focusOnLinkStoveAndOven() {
        startPage.linkStoveAndOvens().focusOnLink();
    }

    @Когда("Навести курсор на ссылку ПК, ноутбуки, периферия")
    //Навести курсор на ссылку (Компьютеры и периферия) ПК, ноутбуки, периферия
    public void focusOnLinkComputers() {
        startPage.linkComputers().focusOnLink();
    }


    // Перейти на страницу "Бытовая техника"
    @Когда("Выполнен переход на страницу Бытовая техника")
    public void goToAppliancesPage() {
        // Нажатие на ссылку "Бытовая техника"
        startPage.linkAppliance().click();
        logger.info("Открыта страница [Бытовая техника]");
    }

    // Перейти на страницу "Плиты и печи"
    @Тогда("Выполнен переход на страницу Плиты и печи")
    public void goToStoveAndOvensPage() {
        // Нажатие на ссылку "Плиты и печи"
        startPage.linkStoveAndOvens().click();
        logger.info("Открыта страница [Плиты и печи]");
    }

    // Перейти на страницу "Ноутбуки"
    @Тогда("Выполнен переход на страницу Ноутбуки")
    public void goToLaptopsPage() {
        // Нажатие на ссылку "Ноутбуки"
        startPage.linkLaptops().click();
        logger.info("Открыта страница [Ноутбуки]");
    }

    // Проверить, что отображаются ссылки: Встраиваемая техника, Техника для кухни, Техника для дома
    @Тогда("Проверить, что отображаются ссылки: Встраиваемая техника, Техника для кухни, Техника для дома")
    public void isDisplayedLinkApplianceSubcategories(List<String> args) {
        WebDriver driver = WebDriverFactory.getCurrentDriver();
        for (String element : args) {
            WebElement el = driver.findElement(By.xpath("//a[text()=\"" + element + "\"]"));
            Assertions.assertTrue(el.isDisplayed(), "ERROR!Ссылка " + el.getText() + " не отображается");
        }
        logger.info("Все ОК! Ссылки: Встраиваемая техника, Техника для кухни, Техника для дома отображаются");
    }

}