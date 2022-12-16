package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

import java.util.List;

// Страница "Техника для кухни"
public class KitchenAppliancePage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(KitchenAppliancePage.class);

    // ***** Веб элементы *****
    // Cсылка "Собрать свою кухню"
    @FindBy(xpath = "//a[text()='Собрать свою кухню']")
    private WebElement linkAssembleKitchen;
    // Все категории техники для кухни
    @FindBy(xpath = "//span[@class='subcategory__title']")
    private List<WebElement> kitchenCategories;
    // Текст Техника для кухни
    @FindBy(xpath = "//h1[text()='Техника для кухни']")
    private WebElement linkKitchenAppliance;


    // Конструктор класса
    public KitchenAppliancePage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // Ссылка "Собрать свою кухню"
    public Link linkAssembleKitchen() {
        return new Link(linkAssembleKitchen);
    }

    // Все категории техники для кухни
    public List<WebElement> kitchenCategories() {
        return kitchenCategories;
    }

    // Текст Техника для кухни
    public Link linkKitchenAppliance() {
        return new Link(linkKitchenAppliance);
    }

}