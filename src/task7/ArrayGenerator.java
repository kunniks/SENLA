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
        System.out.println("Сгенерирован массив из " + array.length + " двузначных чисел");
        System.out.println("Наименьшее число: " + getMin(array) + "\nНаибольшее число: " + getMax(array));

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

    private static int[] createArray(int n) {
        int[] ar = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            ar[i] = random.nextInt(90) + 10;
        return ar;
    }

    private static int getMin(int[] ar){
        Arrays.sort(ar);
        return ar[0];
    }

    private static int getMax(int[] ar){
        Arrays.sort(ar);
        return ar[ar.length - 1];
    }
}
