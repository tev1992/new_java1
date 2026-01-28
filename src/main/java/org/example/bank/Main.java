package org.example.bank;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Лицевой счет 1", 0, "Евгений");
        bankAccount.deposit(2);
        bankAccount.deposit(-1);
        bankAccount.deposit(1000);
        bankAccount.deposit(0);
        bankAccount.deposit(-1001);
    }
}
