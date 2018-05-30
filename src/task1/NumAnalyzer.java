package task1;

import java.math.BigInteger;
import java.util.Scanner;

/* Задание №1.
Создать программу, которая будет сообщать, является ли целое число, введенное пользователем,
чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.

Простое число — натуральное (целое положительное) число,
имеющее ровно два различных натуральных делителя — единицу и самого себя.
Составное число — натуральное число, которое больше единицы и которое не является простым.
Отрицательные, нецелые числа и (как правило) ноль к натуральным не относят.
*/

public class NumAnalyzer {

    public static void main (String [] args){
        start();
    }

    private static void start() {
        analyzeInt(inputN());
    }

    private static int inputN() {
        Scanner input = new Scanner(System.in);
        int k;
        while (true) {
            System.out.print("Введите число любое целое число: ");
            try {
                k = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Принимается только целое число. Попробуйте снова.");
            }
        }
        return k;
    }

    private static void analyzeInt(int i) {
        //Формируем ответ для пользователя:
        String answer = "Принято число " + i + "\nВведенное число: ";

        // Четное или нечетное?
        if (i % 2 == 0)
            answer += "четное";
        else
            answer += "нечетное";

        //Число натуральное?
        if (i < 1)
            answer += ", не является ни простым, ни составным";
        else {
            //Число простое? Используем тест простоты Рабина-Миллера
            BigInteger bigInteger = BigInteger.valueOf(i);
            boolean isPrime = bigInteger.isProbablePrime((int) Math.log(i));
            if (isPrime)
                answer += ", простое";
            else
                answer += ", составное";
        }
        //выводим ответ на экран
        System.out.println(answer);
    }
}
