package org.example.HomeAutoSystem.interfaces;

// 2 шаг Интерфейс для устройств с измеряемыми параметрами (температура, влажность и т.д.)
public interface Measurable { //для устройств с измеряемыми значениями (термостат).

    //Получить текущее измеряемое значение
    double getCurrentValue(); // получить текущее измерение (температуру)

    //Установить целевое значение
    void setTargetValue(double value); // установить целевое значение

}
