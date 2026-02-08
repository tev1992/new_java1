package org.example.practicJavaCourceOOP;

// =====  БАЗОВЫЙ КЛАСС ДЛЯ ПРЕДСТАВЛЕНИЯ КНИГИ Реализует инкапсуляцию - все поля приватные =====

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean isAvailable;



    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true; // Новая книга всегда доступна!
        this.isbn = isbn;
    }



    // ===== ГЕТТЕРЫ (МЕТОДЫ ДЛЯ ПОЛУЧЕНИЯ ЗНАЧЕНИЙ) =====
    public String getTitle(){
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public boolean isAvailable(){return isAvailable;}//* Для boolean-полей геттер начинается с "is", а не "get"
    public String getIsbn(){return isbn;}

    // ===== СЕТТЕРЫ (МЕТОДЫ ДЛЯ УСТАНОВКИ ЗНАЧЕНИЙ) ===== vailable - новый статус: true (доступна) или false (в аренде)
    public void setAvailable(boolean vailable) {
        this.isAvailable = vailable;
    }

    public void displayInfo() {
        System.out.println( "\nДанные о книге: " +
                "\n Название: " + title +
                "\n Автор: " + author +
                "\n Автор: " + isbn +
                "\n Год выпуска: " + publicationYear +
                "г" +
                "\n статус " + (isAvailable? "Доступно" : "Не доступно"));
    }

}

// ===== КЛАССЫ-НАСЛЕДНИКИ (ДЕМОНСТРАЦИЯ НАСЛЕДОВАНИЯ И ПОЛИМОРФИЗМА) =====

class FixtionBook extends Book {
    String genre;


    public FixtionBook(String title, String author, String isbn, int publicationYear, String genre) {
        super(title, author, isbn, publicationYear);
        this.genre = genre; // Дополнительное поле: жанр литературы

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Жанр: " + genre + " (Художественная литература)");
    }

    public String getGenre() {
        return genre;
    }

}

class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, String isbn, int publicationYear, String subject) {
        super(title, author, isbn, publicationYear);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" Предмет: " + subject);
    }
}

class ReferenceBook extends Book {
    private String field;

    public ReferenceBook(String title, String author, String isbn, int publicationYear, String field) {
        super(title, author, isbn, publicationYear);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" Область: " + field + " (Справочник)");
    }
}




