package org.example.HomeAutoSystem.interfaces;

// 2 шаг
public interface Measurable { //для устройств с измеряемыми значениями (термостат).
    double getCurrentValue(); // получить текущее измерение (температуру)
    void setTargetValue(double value); // установить целевое значение

}
