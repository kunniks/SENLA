package task9;

import java.util.Scanner;

/* Задание №9
Написать программу, выводящую на экран все четные числа и их сумму из последовательности от 0 до N.
N вводится вручную.
*/
public class EvenNumCalc {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int n = inputN();
        System.out.println("В последовательности чисел от 0 до " + n + " имеются четные числа:");
        printEven(n);
        System.out.println("Сумма четных чисел последовательности от 0 до " + n + ": " + calcEvenSum(n));
        
    }

    private static int inputN() {
        Scanner input = new Scanner(System.in);
        int k;
        while (true) {
            System.out.print("Введите число N: ");
            try {
                k = Integer.parseInt(input.nextLine());
                if (k >= 0 ) // допускаем, что последовательность может состоять из 1 элемента, иначе заменить на k>0
                    break;
                else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Принимается только натуральное число. Попробуйте снова.");
            }
        }
        return k;
    }
    private static void printEven(int k) {
        //первое четное число в нашей последовательности всегда ноль, от него и будем считать
        for (int i = 0; i <= k; i+=2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static int calcEvenSum(int k) {
        //первое четное число в нашей последовательности всегда ноль, от него и будем считать
        int sum = 0;
        for (int i = 0; i <=k; i+=2) {
            sum+=i;
        }
        return sum;
    }
}
