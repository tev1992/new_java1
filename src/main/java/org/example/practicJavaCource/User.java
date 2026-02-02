package org.example.practicJavaCource;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCount = 1;
    private int id;
    private String name;
    private int age;
    private List<Book> rentedBooks;// Список книг, которые пользователь арендовал

    public User(String name, int age) {
        this.id = idCount++;
        this.name = name;
        this.age = age;
        this.rentedBooks = new ArrayList<>();
    }

    private int getID() {
        return id++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    // ===== МЕТОДЫ ДЛЯ УПРАВЛЕНИЯ АРЕНДОЙ =====

    //Арендовать книгу
    public boolean rentBook(Book book){
        if (book.isAvailable()) {
            // 1. Добавляем книгу в список арендованных
            rentedBooks.add(book);
            // 2. Меняем статус книги на "в аренде"
            book.setAvailable(false);
            return true; // Успешная аренда
        }
        return false; // Книга недоступна
    }
    //снять аренду
    public boolean delBook(Book book) {
        // ПРОВЕРКА: есть ли эта книга в списке арендованных?
        if (rentedBooks.contains(book)) {
            rentedBooks.remove(book);
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    /**
     * ОТОБРАЖЕНИЕ ИНФОРМАЦИИ О ПОЛЬЗОВАТЕЛЕ
     * Выводит все данные пользователя и список арендованных книг
     */
    public void displayInfo() {
        System.out.println("\n=== ДАННЫЕ ПОЛЬЗОВАТЕЛЯ ===" +
                "\n ID: " + id +
                "\n Имя: " + name +
                "\n Возраст: " + age + " лет" +
                "\n Книг в аренде: " + rentedBooks.size());
        if (!rentedBooks.isEmpty()) {
            System.out.println("Список арендованных книг: ");
            for (Book book : rentedBooks) {
                System.out.println(" - " + book.getTitle());
            }
        }
        else {
            System.out.println("Книги не арендованы");
        }

    }

}
