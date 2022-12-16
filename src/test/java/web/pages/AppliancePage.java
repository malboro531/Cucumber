package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

// Страница "Бытовая техника"
public class AppliancePage extends BasePage {

    // Логгер
    private Logger logger = LogManager.getLogger(AppliancePage.class);

    // ***** Веб элементы *****
    // Заголовок страницы
    @FindBy(xpath = "//h1[@class='subcategory__page-title']")
    private WebElement baseElementAppliance;
    // Ссылка на "Техника для кухни"
    @FindBy(xpath = "//span[text()='Техника для кухни']")
    private WebElement linkKitchenAppliance;


    // Конструктор класса
    public AppliancePage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // Заголовок страницы
    public Link linkAppliance() {
        return new Link(baseElementAppliance);
    }

    // Ссылка на "Техника для кухни"
    public Link linkKitchenAppliance() {
        return new Link(linkKitchenAppliance);
    }
}