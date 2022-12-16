package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;

public class BaseElement {
    // Веб элемент
    protected WebElement webElement;
    // Конструктор класса
    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    // Получение оборачиваемого веб элемента
    // Получив оборачиваемый веб элемент, можно вызвать его методы
    // Например, getText()
    public WebElement getWebElement() {
        return webElement;
    }

    public String getText() {return webElement.getText();}

    public void focusOnBaseElement() {ActionHelper.moveToElement(webElement);}

}
