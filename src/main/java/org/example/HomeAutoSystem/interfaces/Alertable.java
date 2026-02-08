package org.example.HomeAutoSystem.interfaces;

public interface Alertable {
    void sendAlert(String message); // отправить предупреждение
    void enableAlerts(boolean enabled); // включить, выключить уведомления
}
