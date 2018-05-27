package task6;

import java.util.Scanner;

/* Задание №6.
Написать программу, которая проверяет три отрезка на возможность
создать прямоугольный треугольник. Длина отрезков вводится вручную.
 */
public class Main {

    public static void main(String[] args) {
        // проверка входящих данных и приведение их к формату
        // пока пользователь не введет корректные значения, программа не завершится
        Scanner input = new Scanner(System.in);
        int[] x = new int[3];
        for (int i = 1; i < 4;) {
            System.out.print("Задайте длину отрезка №" + i + "): ");
            if (!input.hasNextInt()) {
                System.out.println("Вы ввели недопустимое значение (необходимо ввести целое число)");
                input.next();
            } else {
                x[i - 1] = input.nextInt();
                i++;
            }
        }


    }

}
