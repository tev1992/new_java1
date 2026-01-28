package org.example.product;

public class Product {
    public int ID;
    public String name;
    public double price;
    public int count;
    public String currency;


    public Product(String name, double price, int count) {
        this.ID = 1;
        this.name = name;
        this.price = price;
        this.count = count;
        this.currency = "RUB";
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
