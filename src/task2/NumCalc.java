package task2;

import java.util.Scanner;

/* Задание №2.
Создать программу, которая будет вычислять и выводить на экран
сумму, разность, НОК и НОД двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.

Наименьшее общее кратное (НОК) двух целых чисел m и n есть наименьшее натуральное число,
которое делится на m и n без остатка
Наибольшим общим делителем (НОД) для двух целых чисел m и n называется наибольший из их общих делителей.
Наибольший общий делитель существует и однозначно определён, если хотя бы одно из чисел m или n не равно нулю.

*/

public class NumCalc {

    public static void main (String [] args) {
        start();
    }

    private static void start() {
        int[] x = inputNum();
        // Вычислим и выведем на экран сумму и разность
        System.out.println("Сумма введенных чисел: " + (x[0] + x[1]));
        System.out.println("Разность введенных чисел: " + (x[0] - x[1]));

        // Вычисляем НОД (gcd) и НОК (lcm) и выводим результат на экран
        // Философия, как всегда, в делении на ноль.
        // Исходя из определений понятий (приведены выше), допускаем, что мы можем вычислить НОК и НОД,
        // если хотя бы одно из чисел не ноль
        int gcd;
        if (x[0]!=0 || x[1] !=0) {
            gcd = calc_gcd(x[0], x[1]);
        	System.out.println("НОК введенных чисел: " + calc_lcm(x[0], x[1], gcd));
            System.out.println("НОД введенных чисел: " + gcd);
        }
        else
            System.out.println("НОК и НОД введенных чисел определить невозможно");
    }

    private static int[] inputNum() {
        int array [] = new int[2];
        int k;
        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 3; i++) {
            while (true) {
                System.out.print("Введите любое целое число (" + i + "-ое из 2-х): ");
                try {
                    k = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Необходимо ввести целое число. Попробуйте снова.");
                }
            }
            array[i-1] = k;
        }

        return array;
    }

    private static int calc_gcd (int a, int b) {
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a); // коррекция для входящих отрицательных чисел
    }

    private static int calc_lcm (int a, int b, int gcd) {
        int i = a / gcd * b;
        return Math.abs(i); // коррекция для входящих отрицательных чисел
    }
}
