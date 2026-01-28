package org.example.bank;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;
    private boolean isActive;
    private String currency;

    public BankAccount(String accountNumber, double initialBalance , String ownerName) {
        this.accountNumber = accountNumber; //номер счета
        this.balance = initialBalance ; //баланс
        this.ownerName = ownerName; //имя владельца
        this.isActive = true; //статус
        this.currency = "RUB"; //валюта
    }

    public void info(){
        System.out.println("\n" + "Уведомление об операции со счетом " + accountNumber + ". Владелец " + ownerName);
    }

    public void deposit(double sum) {
        info();
        if (sum > 0) {
            balance += sum;
            System.out.println("Внесено " + sum + " " + currency + ", " + " на счету: " + balance + " " + currency);
        } else if (sum < 0) {
            double subtraction = -sum;
            if (balance >= subtraction) {
                balance -= subtraction;
                System.out.println("Снято " + sum + " " + currency + ", " + " на счету: " + balance + " " + currency);
            } else {
                System.out.println("Недостаточно средств для списания");
            }

        } else {
            System.out.println("Внесенная сумма не может быть 0");
        }

    }

}
