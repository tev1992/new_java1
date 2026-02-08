package org.example.calculator;


public class Calc {
    private double x;
    private String math;
    private double y;

    public Calc(double x, String math, double y) {
        this.x = x;
        this.math = math;
        this.y = y;
    }

    public double MathX() {
        double result = 0;
        if (y == 0 && math.equals("/")) {
            System.out.println("Деление на 0 недопустимо");
            return result;
        }

        if (math == "+") {
            result = x + y;
            System.out.println("Сумма равна: " + result);
            return result;
        }
        if (math == "-") {
            result = x - y;
            System.out.println("Сумма равна: " + result);
            return result;
        }
        if (math == "*") {
            result = x * y;
            System.out.println("Сумма равна: " + result);
            return result;
        }

        if (math == "/") {
            result = x / y;
            System.out.println("Сумма равна: " + result);
            return result;
        }

        else {
            System.out.println("Не верное математическое действие");
            return result;
        }
    }
}
