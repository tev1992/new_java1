package org.example.practicJavaCourceOOP;

public class main {

    public static void main(String[] args) {
    Book book1 = new Book("Черепашки ниндзя", "Йохан", "ЛЯЛЯ", 1990);
    User user = new User("Васичкин", 19);
    Library library = new Library("Центральная городская библиотека");
    book1.displayInfo();
    user.displayInfo();
    user.rentBook(book1);
    library.addBook(book1);


    }
}
