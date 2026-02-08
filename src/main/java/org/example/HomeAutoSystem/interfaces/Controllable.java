package org.example.HomeAutoSystem.interfaces;

// 1 шаг
public interface Controllable { //Устройство может включаться
    void turnOn(); //можно boolean
    void turnOff();
    boolean isOn();

}
