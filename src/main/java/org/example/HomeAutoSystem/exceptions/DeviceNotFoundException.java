package org.example.HomeAutoSystem.exceptions;

//extends RuntimeException — говорим "это исключение"
/**
 * Исключение, выбрасываемое при попытке обратиться к несуществующему устройству
 */
public class DeviceNotFoundException extends RuntimeException {

    //конструктор принимает сообщение и передаёт его родителю
    /**
     * Конструктор с сообщением об ошибке
     * @param message детали ошибки
     */
    public DeviceNotFoundException (String message) {
        super(message);
    }

}
