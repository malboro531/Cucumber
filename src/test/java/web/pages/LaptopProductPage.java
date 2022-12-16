package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.BaseElement;
import web.elements.Button;

// Страница "Продукт. Ноутбук"
public class LaptopProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(LaptopProductPage.class);

    // ***** Веб элементы *****
    //Кнопка "Развернуть все"
    @FindBy(xpath = "//button[contains(@class, 'product-characteristics__expand')]")
    private WebElement buttonAllSpecifications;
    // Модель ноутбука (в характеристиках)
    @FindBy(xpath = "//*[text() = ' Модель ']/following-sibling::div")
    private WebElement baseElementChCompany;
    //Объем оперативной памяти ноутбука (в характеристиках)
    @FindBy(xpath = "//*[text() = ' Объем оперативной памяти ']/following-sibling::div")
    private WebElement baseElementChRAM;

    // Конструктор класса
    public LaptopProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****

    //Кнопка "Развернуть все"
    public Button buttonAllSpecifications() {
        return new Button(buttonAllSpecifications);
    }

    // Модель ноутбука (в характеристиках)
    public BaseElement baseElementChCompany() {
        return new BaseElement(baseElementChCompany);
    }

    // Объем оперативной памяти ноутбука (в характеристиках)
    public BaseElement baseElementChRAM() {
        return new BaseElement(baseElementChRAM);
    }

}