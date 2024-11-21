package com.walking.intensive.chapter1.task4;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0"
 * <li> "Бесконечное множество решений"
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>Если с указанными коэффициентами уравнение некорректно - метод должен вернуть строку
 * "Некорректные входные данные".
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double c = -10;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {

        if (a == 0) {
            if (b == 0 && c == 0) {
                return "Бесконечное множество решений";
            }
            if (b == 0 && c != 0) {
                return "Количество решений: 0";
            }
            if (b != 0) {
                double x = -c / b;
                return "Количество решений: 1. Корень: " + x;
            }
        }

        if (a != 0) {
            double d = Math.pow(b, 2) - (4 * a * c);

            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);

                if (x1 < x2) {
                    return "Количество решений: 2. Корни: " + x1 + ";" + x2;
                }
                return "Количество решений: 2. Корни: " + x2 + ";" + x1;
            }
            if (d == 0) {
                double x = -b / (2 * a);
                return "Количество решений: 1. Корень: " + x;
            }
            if (d < 0) {
                return "Количество решений: 0";
            }
        }
        return "Бесконечное множество решений";
    }
}
