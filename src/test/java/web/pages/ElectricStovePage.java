package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Страница "Электрические плиты"
public class ElectricStovePage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(ElectricStovePage.class);

    // ***** Веб элементы *****
    // Количество товаров в тексте Плиты электрические [количество]
    @FindBy(xpath = "//span[@class='products-count']")
    public WebElement baseElementCountElectricStove;

    // Конструктор класса
    public ElectricStovePage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // Количество товаров в тексте Плиты электрические [количество]
    public String intCountElectricStove() {
        String textElectricStove = baseElementCountElectricStove.getText().replaceAll("[^0-9]+", "");
        return textElectricStove;
    }

}