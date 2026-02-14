package org.example.HomeAutoSystem.devices;

import org.example.HomeAutoSystem.interfaces.Alertable;
import org.example.HomeAutoSystem.interfaces.Controllable;
import org.example.HomeAutoSystem.interfaces.Measurable;

// Абстрактный базовый класс для всех устройств умного дома
// Содержит общие поля и методы для всех устройств
public abstract class Device {

    public static int countId = 1; //Счётчик для автоматической генерации уникальных ID
    private int id;
    protected String name; // поля будут доступны в дочерних классах, на рабочем проекте делают private
    protected String type; //Тип устройства (доступно в классах-наследниках)

    public Device(String name, String type) { //Конструктор устройства
        this.id = countId++;
        this.name = name;
        this.type = type;
    }

    //Получить ID устройства
    public int getId() {
        return id;
    }

    //Получить название устройства
    public String getName() {
        return name;
    }

    //Получить тип устройства
    public String getType() {
        return type;
    }

    //Строковое представление устройства
    public String toString() { //System.out.println(device) автоматически вызывает device.toString()
        return "Device{id=" + id + ", name=" + name + ", type=" + type + "}";
    }
}

