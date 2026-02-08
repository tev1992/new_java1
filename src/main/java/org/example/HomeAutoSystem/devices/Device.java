package org.example.HomeAutoSystem.devices;

import org.example.HomeAutoSystem.interfaces.Alertable;
import org.example.HomeAutoSystem.interfaces.Controllable;
import org.w3c.dom.ls.LSOutput;

public abstract class Device {
    public static int countId = 1;
    private int id;
    protected String name; // поля будут доступны в дочерних классах, на рабочем проекте делают private
    protected String type;

    public Device(String name, String type) {
        this.id = countId++;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Device{id=" + id + ", name=" + name + ", type=" + type + "}";
    }
}

class Light extends Device implements Controllable, Alertable {
    private int brightness; // от 0 до 100
    private String color; //цвет
    private boolean isOn;

    public Light(String name, String type, int brightness, String color) {
        super(name, type);
        this.brightness = brightness;
        this.color = color;
        this.isOn = false; // по дефолту устройство выключено
    }

    public void setBrightness(int value) {
        if (value < 0 || value > 100) {
            System.out.println("Недопустимые значения яркости");
            return; // выход из метода, чтобы не устанавливать некорректное значение
        }
        brightness = value;
        System.out.println("Яркость установлена " + value + "%");
    }

    public void setColor(String setCol) {
        if (!setCol.equals("Blue") && !setCol.equals("White") && !setCol.equals("Green")) {
            System.out.println("Не верное выбор цвета освещения");
            return;
        }
        color = setCol;
        System.out.println("Цвет освещения выбран: " + setCol);

    }

    public int getBrightness() {
        return brightness;
    }

    public String getColor() {
        return color;
    }


    @Override
    public void sendAlert(String message) {
        System.out.println("Предупреждение отправлено: " + message);
    }

    @Override
    public void enableAlerts(boolean enabled) {
        if (enabled) {
            System.out.println("Уведомления включены!");
        } else {
            System.out.println("Уведомления отключены!");
        }
    }

    @Override
    public void turnOn() {
        isOn = true; //смена состояния
        System.out.println("Устройство включено");
    }

    @Override
    public void turnOff() {
        isOn = false; //смена состояния
        System.out.println("Устройство отключено");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}