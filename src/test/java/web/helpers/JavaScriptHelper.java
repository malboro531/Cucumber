package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class JavaScriptHelper {
    // Логгер
    private static Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    // Исполнитель JavaScript скриптов
    protected static JavascriptExecutor javascriptExecutor;
    // Инициализация исполнителя JavaScript скриптов
    public static void init(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    // Получение рамзеров экрана (для скриншотов)
    public static float getPageSize () {
        Object output = ((JavascriptExecutor) javascriptExecutor).executeScript("return window.devicePixelRatio");
        String value = String.valueOf(output);
        float windowDPR = Float.parseFloat(value);
        return windowDPR;
    }

    // Скролл страницы на заданное расстояние в пикселях по X и по Y
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);
        // Добавление задержки
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Скролл страницы на элемент
    public static void scrollToElement(WebElement element){
        String script = "arguments[0].scrollIntoView(false);";
        javascriptExecutor.executeScript(script, element);
        // Добавление задержки
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Установка невидимости веб элемента
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        javascriptExecutor.executeScript(script, element);
        // Добавление задержки
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Плавный скролл страницы для качественных скриншотов
    public static void slowScroll() {
        for (int i = 0; i < 1000; i++) {
                javascriptExecutor.executeScript("window.scrollBy(0,5)", "");
            }
    }

}