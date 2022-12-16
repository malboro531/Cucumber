package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

import java.io.Serializable;

// Класс "Ноутбук"
public class Laptop implements Serializable {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Company company;

    // Конструктор по умолчанию
    public Laptop() {
    }

    // Конструктор
    public Laptop(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    // Сеттеры и геттеры

    // Оперативная память
    public void setRam(Ram ram) {
        this.ram = ram;
    }
    public Ram getRam() {
        return this.ram;
    }

    // Производитель
    public void setCompany(Company сompany) {
        this.company = сompany;
    }
    public Company getCompany() {
        return this.company;
    }

}