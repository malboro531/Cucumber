package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    // Логгер
    private static Logger logger = LogManager.getLogger(ScreenshotHelper.class);
    // Веб драйвер
    private static WebDriver screener;
    // Инициализация драйвера
    public static void init(WebDriver driver) {
        screener = driver;
    }

    public static void screenshot(String screenName) {
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(
                            ShootingStrategies.scaling(JavaScriptHelper.getPageSize()), 100))
                    .takeScreenshot(screener);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\" + screenName));
            logger.info("Скриншот сохранен в файле [temp\\" + screenName);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
