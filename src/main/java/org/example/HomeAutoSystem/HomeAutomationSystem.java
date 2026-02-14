package org.example.HomeAutoSystem;

import org.example.HomeAutoSystem.devices.Device;
import org.example.HomeAutoSystem.devices.Light;
import org.example.HomeAutoSystem.exceptions.DeviceNotFoundException;
import org.example.HomeAutoSystem.exceptions.DuplicateDeviceException;
import org.example.HomeAutoSystem.interfaces.Controllable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Центральная система управления умным домом
 * Хранит все устройства и предоставляет методы для управления ими
 */

public class HomeAutomationSystem {
    private List<Device> devicesList = new ArrayList<>(); //Список всех устройств (для последовательного перебора)
    private Map<Integer, Device> deviceMap = new HashMap<>(); // Карта устройств для быстрого доступа по ID (ключ - ID, значение - устройство)

    //конструктор пустой, так как коллекции уже инициализированы при объявлении полей

    // ================== Методы добавления устройств ==================


    //метод до обработки исключений
    /**
     * Добавить устройство в систему (без исключений)
     * @param device устройство для добавления
     */
    public void addDevice(Device device) { //добавление в список
        if (deviceMap.containsKey(device.getId())) {
            System.out.println("Данный обьект уже добавлен в мапу");
            return;
        }
        deviceMap.put(device.getId(), device);
        devicesList.add(device);
        System.out.println("Устройство " + "'" + device.getName() + "'" + " добавлено в список 'List' и 'Мап'");


    }

    //метод после обработки исключений
    /**
     * Добавить устройство в систему с проверкой через исключение
     * @param device устройство для добавления
     * @throws DuplicateDeviceException если устройство с таким ID уже существует
     */
    public void addDevice2 (Device device){
        if (deviceMap.containsKey(device.getId())) {
            throw new DuplicateDeviceException("Устройство с ID=" + "'" + device.getName() + "'" + " уже существует");
        }
        deviceMap.put(device.getId(), device);
        devicesList.add(device);
        System.out.println("Устройство " + "'" + device.getName() + "'" + " добавлено в список 'List' и 'Мап'");

    }

    // ================== Методы удаления устройств ==================


    //метод до обработки исключений
    /**
     * Удалить устройство по ID (без исключений)
     * @param id идентификатор устройства
     */
    public void removeDevice(int id) {
        if (deviceMap.containsKey(id)) {
            // 1. Сохраняем устройство ДО удаления
            Device device = deviceMap.get(id);
            String devicename = device.getName();

            // Удаление из списка
            for (int i = 0; i < devicesList.size(); i++) {
                if (devicesList.get(i).getId() == id) {
                    devicesList.remove(i);
                    break;
                }
            }
            // Удаление из карты
            deviceMap.remove(id);
            System.out.println("Устройство " + "'" +  devicename + "'" + " по данному id=" + id + " удалено");
        } else {
            System.out.println("Устройство по id=" + id + " не найдено");
        }
    }

    //метод после обработки исключений
    /**
     * Удалить устройство по ID с использованием исключения
     * @param id идентификатор устройства
     * @throws DeviceNotFoundException если устройство с таким ID не найдено
     */
    public void remoteDevice2(int id) {
        Device device = deviceMap.remove(id); // удаляем из карты и получаем устройство

        if (device == null) {
            throw new DeviceNotFoundException("Устройство с ID=" + id + " не найдено");
        }

        // Удаление из списка
        devicesList.remove(device);
        System.out.println("Устройство '" + device.getName() + "' (ID=" + id + ") удалено");
    }

    // ================== Методы поиска устройств ==================

    //метод до обработки исключений
    /**
     * Найти устройство по ID (без исключений)
     * @param id идентификатор устройства
     * @return устройство или null, если не найдено
     */
    public Device getDevice(int id) { //метод возвращает обьект типа Device по id
        Device device = deviceMap.get(id);
        if (device != null) {
            System.out.println("Найдено устройство " + device.getName());
        } else {
            System.out.println("Устройство с данным id=" + id + " не найдено");
        }
        return device;
    }

    //метод после обработки исключений
    /**
     * Найти устройство по ID с использованием исключения
     * @param id идентификатор устройства
     * @return устройство
     * @throws DeviceNotFoundException если устройство не найдено
     */
    public Device getDevice2 (int id) {
        Device device = deviceMap.get(id);
        if (device == null) {
            throw new DeviceNotFoundException("Устройство с ID=" + id + " не найдено");
        }
        System.out.println("Найдено устройство " + device.getName());
        return device;
    }

    /**
     * Получить список всех устройств
     * @return список всех устройств в системе
     */
    public List<Device> getAllDevices() { // возвращает список устройств
        return devicesList;
    }

    /**
     * Вывести в консоль информацию обо всех устройствах
     */
    public void printAllDevices() { //метод для печати всех устройств
        System.out.println("\nСписок всех устройств:");
        if (devicesList.isEmpty()) {
            System.out.println("В системе нет устройств");
        } else {
            for (Device device : devicesList) {
                System.out.println(" " + device);
            }
        }
        System.out.println("количество устройств в список " + devicesList.size());
    }

    // ================== Методы управления всеми устройствами ==================

    //Включить все устройства, которые могут включаться (реализуют Controllable)
    public void turnOnAllDevices() {
        int count = 0;
        for (Device device : devicesList) {
            if (device instanceof Controllable) {
                //instanceof проверяет, является ли объект экземпляром определённого класса или
                // реализует ли он определённый интерфейс.
                //public class Light extends Device implements Controllable, Alertable
                ((Controllable) device).turnOn();
                count ++;
            }
        }
        if (count == 0) {
            System.out.println("Нет устройств, которые можно включить");
        }
        System.out.println("Включено устройств: " + count);
    }

    //Отключить все устройства, которые могут включаться (реализуют Controllable)
    public  void turnOffAllDevices() {
        int count = 0;
        for (Device device : devicesList) {
            if (device instanceof Controllable) {
                Controllable ctr = (Controllable) device;
                ctr.turnOff();
                // или так ((Controllable) device).turnOff();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Нет устройств, которые можно отключить");
        }
        System.out.println("Отключено устройств " + count);
    }


    // ================== Методы поиска по критериям ==================

    /**
     * Найти все устройства заданного типа
     * @param type тип устройства (например, "LED", "Thermostat")
     * @return список устройств указанного типа
     */
    public List<Device> findDevicesByType(String type) {
        List<Device> result = new ArrayList<>();
        for (Device device : devicesList) {
            if (device.getType().equals(type)) {
                System.out.println("Найдено устройство по " + type + ": " + device);
                result.add(device);
                }
            }
        if (result.isEmpty()) {
            System.out.println("Устройства типа " + type + " не найдены");
        }
    return result;
    }

    /**
     * Найти все устройства по статусу включения
     * @param on true - искать включенные, false - искать выключенные
     * @return список устройств с указанным статусом
     */
    public List<Device> getDevicesByStatus(boolean on) {
        List<Device> result = new ArrayList<>();
        for (Device device : devicesList) {
            if (device instanceof Controllable) {
                Controllable ctrl = (Controllable) device;
                if (ctrl.isOn() == on) {
                    result.add(device);
                }
            }
        }
        String status = on? "Включенных" : "Отключенных";
        System.out.println("Найдено " + status + " устройств: " + result.size());
        if (result.size() > 0 ) {
            for (Device device : result) {
                System.out.println(device);
            }
        }
        return result;
    }




}
