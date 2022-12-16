package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

// Страница "Плиты и печи"
public class StoveAndOvenPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StoveAndOvenPage.class);

    // ***** Веб элементы *****
    // Ссылка на "Электрические плиты"
    @FindBy(xpath = "//span[text()='Плиты электрические']")
    private WebElement linkElectricStove;

    // Конструктор класса
    public StoveAndOvenPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // Ссылка на "Электрические плиты"
    public Link linkElectricStove() {
        return new Link(linkElectricStove);
    }
}