package web.elements;

import web.helpers.ActionHelper;
import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class Accordeon extends BaseElement{
    // Конструктор
    public Accordeon(WebElement webElement) {
        super(webElement);
    }

    // Раскрытие гармошки
    public void show() {
        // Ожидание кликабельности гармошки
        ActionHelper.moveToElement(webElement);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
