package org.example.HomeAutoSystem.devices;

import org.example.HomeAutoSystem.interfaces.Controllable;
import org.example.HomeAutoSystem.interfaces.Measurable;

/**
 * Класс, представляющий термостат для управления температурой
 * Наследуется от Device, реализует интерфейсы Controllable и Measurable
 */
public class Thermostat extends Device implements Controllable, Measurable {
    private double currentTemperature; //Текущая температура в помещении
    private double targetTemperature; //Целевая температура, которую нужно поддерживать
    private String mode; //Режим работы (Обогрев/Охлаждение/Авто)
    private boolean isOn; //Состояние устройства (включено/выключено)

    /**
     * Конструктор для создания термостата
     * @param name название устройства
     * @param type тип устройства
     * @param currentTemperature текущая температура
     * @param targetTemperature целевая температура
     * @param mode режим работы
     */
    public Thermostat(String name, String type, double currentTemperature, double targetTemperature) {
        super(name, type);
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.isOn = false;
        this.mode = "Авто";

    }
    /**
     * Получить текущую температуру
     * @return текущая температура
     */
    public double getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     * Получить целевую температуру
     * @return целевая температура
     */
    public double getTargetTemperature() {
        return targetTemperature;
    }

    /**
     * Получить текущий режим работы
     * @return режим работы
     */
    public String getMode() {
        return mode;
    }


    /**
     * Установить режим работы
     * @param modeValue режим (Обогрев/Охлаждение/Авто)
     */
    public void setMode(String modeValue) {
        if (!modeValue.equals("Обогрев") && !modeValue.equals("Охлаждение") && !modeValue.equals("Авто")) {
            System.out.println("Не верно выбран режим работы");
            return;
        }
        mode = modeValue;
        System.out.println("Режим работы выбран " + mode);
    }

    // ================== Реализация Controllable ==================

    //Включить термостат
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Устройство " + "'" + getName() + "'" + " включено");
    }

    //Выключить термостат
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Устройство " + getName() + " отключено");
    }

    /**
     * Проверить, включен ли термостат
     * @return true - включен, false - выключен
     */
    @Override
    public boolean isOn() {
        return isOn;
    }

    // ================== Реализация Measurable ==================

    /**
     * Получить текущее измеряемое значение (температуру)
     * @return текущая температура
     */
    @Override
    public double getCurrentValue() {
        return currentTemperature;
    }

    /**
     * Установить целевую температуру
     * @param value целевая температура (должна быть в диапазоне 0-100)
     */
    @Override
    public void setTargetValue(double value) {
        if (value < 0 || value > 100) {
            System.out.println("Не верное выставление температуры");
            return;
        }
        targetTemperature = value;
        System.out.println("Целевая температура выставлена в " + value + " градусов");
    }
}
