package org.example.HomeAutoSystem.devices;

import org.example.HomeAutoSystem.interfaces.Alertable;
import org.example.HomeAutoSystem.interfaces.Controllable;

/**
 * Класс, представляющий устройство освещения (лампу, люстру, светильник)
 * Наследуется от Device, реализует интерфейсы Controllable и Alertable
 */
public class Light extends Device implements Controllable, Alertable {
    private int brightness; // Яркость света (от 0 до 100)
    private String color; //Цвет свечения
    private boolean isOn; //Состояние устройства (включено/выключено)


    /**
     * Конструктор для создания осветительного устройства
     * @param name название устройства (например, "Люстра в гостиной")
     * @param type тип устройства (например, "LED", "галогенная")
     * @param brightness ightness начальная яркость (0-100)
     * @param color цвет свечения
     */
    public Light(String name, String type, int brightness, String color) {
        super(name, type);
        this.brightness = brightness;
        this.color = color;
        this.isOn = false; // по умолчанию устройство выключено
    }

    /**
     * Установить яркость света
     * @param value значение яркости (должно быть от 0 до 100)
     */
    public void setBrightness(int value) {
        if (value < 0 || value > 100) {
            System.out.println("Недопустимые значения яркости");
            return; // выход из метода, чтобы не устанавливать некорректное значение
        }
        brightness = value;
        System.out.println("Яркость установлена " + value + "%");
    }

    /**
     * Установить цвет свечения
     * @param setCol цвет (доступные: Blue, White, Green)
     */
    public void setColor(String setCol) {
        if (!setCol.equals("Blue") && !setCol.equals("White") && !setCol.equals("Green")) {
            System.out.println("Не верный выбор цвета освещения");
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


    // ================== Реализация Alertable  ==================
    /**
     * Отправить предупреждение от устройства
     * @param message текст предупреждения
     */
    @Override
    public void sendAlert(String message) {
        System.out.println("Предупреждение отправлено: " + message);
    }

    /**
     * Включить или выключить оповещения для устройства
     * @param enabled true - включить, false - выключить
     */
    @Override
    public void enableAlerts(boolean enabled) {
        if (enabled) {
            System.out.println("Уведомления" + getName() + " включены!");
        } else {
            System.out.println("Уведомления" +  getName() + " отключены!");
        }
    }

    // ================== Реализация Controllable ==================

    // Включить свет
    @Override
    public void turnOn() {
        isOn = true; //смена состояния
        System.out.println("Устройство " + "'" + getName() + "'" + " включено");
    }

    // Выключить свет
    @Override
    public void turnOff() {
        isOn = false; //смена состояния
        System.out.println("Устройство " + getName() + " отключено");
    }

    //Проверить, включен ли свет
    @Override
    public boolean isOn() {
        return isOn;
    }
}
