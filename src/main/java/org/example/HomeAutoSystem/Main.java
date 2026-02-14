package org.example.HomeAutoSystem;

import org.example.HomeAutoSystem.devices.Light;
import org.example.HomeAutoSystem.devices.Thermostat;
import org.example.HomeAutoSystem.exceptions.DeviceNotFoundException;

public class Main {
    public static void main(String[] args) {

        // 1. Создаём систему
        HomeAutomationSystem system = new HomeAutomationSystem();

        // 2 Создаем устройство
        Light livingRoomLight = new Light("Люстра", "LED", 80, "Белый");
        Light bedroomLight = new Light("Ночник в спальне", "LED", 30, "Теплый");
        Thermostat mainThermostat = new Thermostat("Гостиная", "Thermostat", 22.5, 23.0);

        // 3 Добавление устройств
        System.out.println("\n--- Добавление устройств ---");
        system.addDevice(livingRoomLight);
        system.addDevice(mainThermostat);
        system.addDevice(bedroomLight);

        // 4. Добавление дубликата
        System.out.println("\n--- Попытка добавить дубликат ---");
        system.addDevice(livingRoomLight);


        // 5. Вывод всех устройств
        System.out.println("\n--- Список всех устройств ---");
        system.printAllDevices();

        // 6. Включаем все устройства
        System.out.println("\n---Включение всех устройств ---");
        system.turnOnAllDevices();

        // 7. Поиск по ID
        System.out.println("\n--- Поиск устройства по ID (id=2) ---");
        system.getDevice(2);

        // 7.1 Поиск по ID с обработкой исключений
        System.out.println("\n--- Поиск устройства по ID (id=99) c с обработкой ошибок ---");
        try {
            system.getDevice2(99);
        } catch (DeviceNotFoundException e) {
            System.out.println("Ошибка " + e.getMessage());

        }

        // 8. Поиск по несуществующему ID
        System.out.println("\n--- Поиск по несуществующему ID (id=99) ---");
        system.getDevice(99);

        // 9. Поиск по типу
        System.out.println("\n--- Поиск устройств типа 'LED' ---");
        system.findDevicesByType("LED");

        // 10. Выключаем все устройства
        System.out.println("\n--- Выключение всех устройств ---");
        system.turnOffAllDevices();

        // 11. Удаляем устройство
        System.out.println("\n--- Удаление устройства с id=2 ---");
        system.removeDevice(2);

        // 12. Проверяем, что удалилось
        System.out.println("\n--- Список после удаления ---");
        system.printAllDevices();

        // 13. Удаляем устройство, по несуществующему ID
        System.out.println("\n--- Удаляем устройство, по несуществующему ID ---");
        system.removeDevice(99);

        // 13.1 Удаляем устройство, по несуществующему ID с обработкой исключения
        System.out.println("\n--- Удаляем устройство, по несуществующему ID с обработкой исключения---");
        try {
            system.remoteDevice2(99);
        } catch (DeviceNotFoundException e) {
            System.out.println("Ошибка " + e.getMessage());
        }


        // 14. Поиск включенных устройств
        System.out.println("\n--- Поиск включенных устройств ---");
        system.getDevicesByStatus(true);

        // 15. Поиск отключенных устройств
        System.out.println("\n--- Поиск Отключенных устройств ---");
        system.getDevicesByStatus(false);

        System.out.println("\n=== РАБОТА ЗАВЕРШЕНА ===");









    }
}
