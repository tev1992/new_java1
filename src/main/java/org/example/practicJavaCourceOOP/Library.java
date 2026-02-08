package org.example.practicJavaCourceOOP;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private List <Book> books;
    private List <User> users;


    public Library(String libraryName) {
    this.libraryName = libraryName;
    this.books = new ArrayList<>();
    this.users = new ArrayList<>();
    }

    /**
     * ДОБАВИТЬ КНИГУ В БИБЛИОТЕКУ
     * @param book - книга для добавления
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга " + book.getTitle() + "добавлена в библиотеку");
    }

    /**
     * Удалить КНИГУ из библиотеки
     */

    public boolean removeBook(String isbn) {
        // ПЕРЕБИРАЕМ ВСЕ КНИГИ В ПОИСКАХ НУЖНОЙ
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                // ПРОВЕРКА: МОЖНО ЛИ УДАЛИТЬ КНИГУ?
                if (!book.isAvailable()) {
                    System.out.println("Ошибка: Книга " + book.getTitle() + " в аренде, удаление невозможно");
                    return false;
                }
                books.remove(book);
                System.out.println("Книга " + book.getTitle() + " удалена");
                return true;

            }
        }
        System.out.println("Книга  " + isbn + " не найдена.");
        return false;
    }

    /**
     * найти пользоватаеля
     */

    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("пользователь найден " + user);
                return user;
            }
        }
        System.out.println("пользователь не найден по " + name);
        return null;
    }


}

