package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import models.Laptop;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.elements.Block;
import web.helpers.JavaScriptHelper;
import web.pages.LaptopsPage;

import java.util.List;
import java.util.Map;

public class
LaptopsPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(LaptopsPageSteps.class);

    // Страница "Ноутбуки"
    private LaptopsPage laptopsPage;

    @Дано("Открыта страница Ноутбуки")
    public void openLaptopsPage() {
        laptopsPage = new LaptopsPage(web.drivers.WebDriverFactory.getCurrentDriver());
    }

    @И("Скрыть блок страницы")
    //Скрыть блок страницы
    public Block getLaptopsBlock() {
        return laptopsPage.blockHeader();
    }

    @И("Установлены фильтры и сортировка из таблицы ASUS")
    public void setFiltersFromTableAsus(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String sortBy = table.get(0).get("Сортировка");
        String filterByCompany = table.get(0).get("Производитель");
        String filterByRam = table.get(0).get("Объем оперативной памяти");

        Laptop laptop = new Laptop(
                new Ram(Integer.parseInt(filterByRam.split(" ")[0])),
                new Company(filterByCompany));

        //Применить сортировку Сначала дорогие
        // Отображение сортировки
        laptopsPage.accordeonSort().show();
        // Установка сортировки
        laptopsPage.radiobuttonSort(sortBy).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установка сортировки <" + sortBy + ">");

        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 1600);
        // Установка фильтра "Производитель"
        laptopsPage.checkboxCompany(laptop.getCompany().getCompany()).setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра \"Производитель\" - <" +
                laptop.getCompany().getCompany() + ">");

        // Отображение фильтра "Объем оперативной памяти"
        laptopsPage.accordeonRAM().show();

        // Установка фильтра "Объем оперативной памяти"
        laptopsPage.checkboxRAM(laptop.getRam().getRam() + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра \"Объем оперативной памяти\" - <" +
                laptop.getRam().getRam() + " ГБ>");

        logger.info("***** Установлены фильтры и сортировка из таблицы с тремя колонками");
    }

    @И("Нажать кнопку Применить")
    //Нажать кнопку Применить
    public void applyFilters() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, 500);
        // Нажатие на кнопку "Применить"
        laptopsPage.buttonApply().click();
        logger.info("Страница [Ноутбуки]: Применение фильтров");
    }

    @И("Применить сортировку Сначала дорогие")
    //Применить сортировку Сначала дорогие
    public void orderBy(String type) {
        // Отображение сортировки
        laptopsPage.accordeonSort().show();
        // Установка сортировки
        laptopsPage.radiobuttonSort(type).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установка сортировки <" + type + ">");
    }

    @И("Перейти на страницу первого продукта в списке \\(новое окно)")
    //Перейти на страницу первого продукта в списке (новое окно)
    public void goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        laptopsPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Ноутбуки]: Переход на страницу первого продукта в списке");
    }

}