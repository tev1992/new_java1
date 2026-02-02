package org.example.product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {

    private List<Product> item; //List<Product> - это "список объектов типа Product"

    public ShoppingCard(){
        item = new ArrayList<>();
    }

    public void addProduct(Product product){
        item.add(product);
        System.out.println("Товар добавлен в конзину " + product.getName());
    }

    public void showCard() {
        if (item.isEmpty()) {
            System.out.println("Ваша корзина пуста");
            return;
        }
        for (Product product : item ) {

            System.out.println("Товаров в корзине" + product.getName() + " " + product.getPrice() + " " +  product.getCurrency());
        }
    }

}
