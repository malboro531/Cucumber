package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Selenium4Listener implements WebDriverListener {
    private Logger logger = LogManager.getLogger(Selenium4Listener.class);

    // После поиска веб элемента
    @Override
    public void afterClick(WebElement element) {
        logger.info("Успешный клик по элементу " + element);
    }
}