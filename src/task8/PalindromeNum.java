package task8;

/* Задание №8
 Написать программу, которая в последовательности от 0 до N находит
 все числа-палиндромы (зеркальное значение равно оригинальному).
 Длина последовательности вводится вручную и не должна превышать 100.

 Исходя из условия задания: 1. Пользователь задает длину последовательности
 2. При максимальной длине последовательности равной 100 элементам последний элемент равен 99 (N=99)
 3. Допускаем, что последовательность чисел может состоять из 1 элемента (исходя из определения числовой последовательности)
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeNum {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int n = inputN();
        System.out.println("В последовательности чисел заданной длины (" + (n) + ") от 0 до " + (n-1) +
                " имеются следующие числа-палиндромы:\n" + palindromeFinder(n));
    }

    private static int inputN() {
        Scanner input = new Scanner(System.in);
        int k;
        while (true) {
            System.out.print("Задайте длину последовательности чисел\n(целое число больше 0 и не превышающее 100): ");
            if (!input.hasNextInt()) {
                System.out.println("Введены недопустимые данные. Попробуйте еще раз.");
                input.next();
            } else {
                k = input.nextInt();
                if (k > 0 && k < 101)
                    break;
                else
                    System.out.println("Ошибка! Введенное число не соответствует условиям. Попробуйте еще раз.");
            }
        }
        return k;
    }


    private static List<Integer> palindromeFinder(int k) {
        List <Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String text = String.valueOf(i);
            if(text.equals(new StringBuilder(text).reverse().toString())) {
                list.add(i);
            }
        }
        return list;
    }
}
