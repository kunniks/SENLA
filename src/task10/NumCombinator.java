package task10;

import java.util.HashSet;
import java.util.Scanner;

/* Задание 10.
Написать программу, составляющую всевозможные комбинации 3-х значных чисел
из 3-х введенных пользователем цифр. Цифры вводятся вручную.
*/
public class NumCombinator {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int num [] = inputNum(); //пользователь вводит цифры
        HashSet<Integer> combs = combinator(num); // сохраняем все комбинации без повторов, только трехзначные числа
        // выводим на экран, проверяя результат
        System.out.print("Из цифр " + num[0] + ", " + num[1] + ", " + num[2] + " ");
        if (combs.size() != 0) {
            System.out.println("можно составить следующие комбинации трехначных чисел:");
            printCombs(combs);
        } else
            System.out.println("невозможно составить трехзначное число");

    }

    private static void printCombs(HashSet<Integer> hs) {
        for (Integer x : hs)
            System.out.print(x + ", ");
        System.out.println("\nколичество комбинаций: " + hs.size());
    }

    private static HashSet<Integer> combinator(int [] a) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int temp = a[i] * 100 + a[j] * 10 + a[k];
                    if (temp > 99 && temp < 1000)
                        hs.add(temp);
                }
            }
        }
        return hs;
    }

    private static int[] inputNum() {
        int array [] = new int[3];
        int k;
        System.out.println("Вам необходимо поочередно ввести три любые цифры " +
                "(т.е. любые целые числа от 0 до 9 включительно)");
        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            while (true) {
                System.out.print("Введите любую цифру (" + i + " из 3): ");
                try {
                    k = Integer.parseInt(input.nextLine());
                    if (k >= 0 && k < 10)
                        break;
                    else
                        throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Необходимо ввести любую цифру. Попробуйте снова.");
                }
            }
            array[i-1] = k;
        }

        return array;
    }
}
