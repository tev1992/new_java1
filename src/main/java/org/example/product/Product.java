package org.example.product;

import java.util.List;

public class Product {
    private int ID;
    private String name;
    private double price;
    private int count;
    private String currency;



    public Product(String name, double price, int count) {
        this.ID = 1;
        this.name = name;
        this.price = price;
        this.count = count;
        this.currency = "RUB";
    }

    public int getID() {
        return ID++;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getCount(){
        return count;
    }

    public String getCurrency(){
        return currency;
    }

    public void displayInfo() {
        System.out.println( "Товар " + name + " по цене " + price + " " + currency + " количество: " + count + " шт." + "\n");
    }

    public void applyDiscount(double percent) {
        double discount = price * (percent / 100);
        if (discount == 0) {
            System.out.println("Скидка не применена");
        }
        else if (percent == 100) {
            price = 0;
            System.out.println("Забирай товар бесплатно =)");
        }
        else if (percent < 0) {
            System.out.println("Размер скидки не может быть отрицательным");
        }
        else if (price > discount) {
            price -= discount;
            System.out.println("Размер скидки составил " + percent + " %" + " что составило " + discount + " " + currency);

        }
        else if (price < discount) {
            System.out.println("Размер скидки больше 100 %");
        }
        else {
            System.out.println("Некорректный ввод процента скидки");
        }
        displayInfo();
    }

}
