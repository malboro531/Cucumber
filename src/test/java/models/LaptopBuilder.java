package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

// Класс строитель объекта "Ноутбук"
public class LaptopBuilder {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Company company;

    // Конструктор
    public LaptopBuilder(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    // Создание объекта "Ноутбук"
    public Laptop build() {
        Laptop laptop = new Laptop();
        laptop.setRam(this.ram);
        laptop.setCompany(this.company);
        return laptop;
    }

}