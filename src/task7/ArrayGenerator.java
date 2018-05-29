package task7;

/* Задание №7.
Написать программу, которая рандомно генерирует
массив 2-ух значных чисел длины N (вводится вручную)
и выводит наименьшее и наибольшее число из списка.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayGenerator {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int[] array = createArray(inputN());
        Arrays.sort(array);
        System.out.println("Сгенерирован массив из " + array.length + " двузначных чисел");
        System.out.println("Наименьшее число: " + array[0] + "\nНаибольшее число: " + array[array.length-1]);

        }

    private static int[] createArray(int n) {
        int[] ar = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            ar[i] = random.nextInt(90) + 10;
        return ar;
    }

    private static int inputN() {
        Scanner input = new Scanner(System.in);
        int k;
        while (true) {
            System.out.print("Задайте длину массива (любое целое число больше ноля): ");
            try {
                k = Integer.parseInt(input.nextLine());
                if (k > 0)
                    break;
                else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введенные данные не соответствуют условиям. Попробуйте еще раз.");
            }
        }
        return k;
    }
}
