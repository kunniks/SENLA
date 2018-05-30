package by.alexdoc.test.tasks.task3;

import by.alexdoc.test.tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Задание №3
Необходимо написать программу, которая проверяет слово на "палиндромность".
Слово для проверки вводится вручную во время выполнения программы.
 */

public class PalindromeWord implements Task {
    @Override
    public void start() {

        String input = getWord();
        if(input == null)
            return;
        if(isPalindrome(input))
            System.out.println("Слово \"" + input + "\" является палиндромом");
        else
            System.out.println("Слово \"" + input + "\" НЕ является палиндромом");
    }

    private static boolean isPalindrome(String text) {
        return text.equalsIgnoreCase(new StringBuilder(text).reverse().toString());
    }

    private static String getWord() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            while (true) {
                System.out.print("Введите одно любое слово: ");
                input = reader.readLine();
                if (input.isEmpty())
                    System.out.println("Ошибка ввода. Проверьте вводимое слово и попробуйте снова");
                else if (input.contains(" "))
                    System.out.println("В слове не может быть пробела! Попробуйте снова");
                else
                    break;
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка. Проверьте введенные данные и попробуйте снова");
        }
        return input;
    }
}
