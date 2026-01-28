package org.example.product;

public class Main {

    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 100, 20);
        apple.displayInfo();
        apple.applyDiscount(10);
        apple.applyDiscount(25);
        apple.applyDiscount(0);
        apple.applyDiscount(110);
        apple.applyDiscount(-10);


    }
}
