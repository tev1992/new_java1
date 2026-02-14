package org.example.HomeAutoSystem.interfaces;

// 1 шаг создаем  Интерфейс для устройств, которыми можно управлять (включать/выключать)
public interface Controllable { //Устройство может включаться
    //Включить устройство
    void turnOn(); //можно boolean
    //Выключить  устройство
    void turnOff();
    //Проверить состояние устройства
    boolean isOn();

}
