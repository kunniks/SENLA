package by.alexdoc.test.tasks.task8;

/* Задание №8
 Написать программу, которая в последовательности от 0 до N находит
 все числа-палиндромы (зеркальное значение равно оригинальному).
 Длина последовательности вводится вручную и не должна превышать 100.

Важно!!!
 Исходя из условия задания: 1. Пользователь задает длину последовательности, а не N
 2. При максимальной длине последовательности равной 100 элементам последний элемент равен 99 (N=99)
 3. Допускаем, что последовательность чисел может состоять из 1 элемента (исходя из определения числовой последовательности)
*/

import by.alexdoc.test.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeNum implements Task {
	@Override
	public void start() {
		int n = inputN();
		System.out.println("В последовательности чисел заданной длины (" + (n) + ") от 0 до " + (n - 1) +
				" имеются следующие числа-палиндромы:\n" + palindromeFinder(n));
	}

	private static int inputN() {
		Scanner input = new Scanner(System.in);
		int k;
		while (true) {
			System.out.print("Задайте длину последовательности чисел\n(целое число больше 0 и не превышающее 100): ");
			try {
				k = Integer.parseInt(input.nextLine());
				if (k > 0 && k < 101)
					break;
				else
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				System.out.println("Ошибка! Введенные данные не соответствуют условиям. Попробуйте еще раз.");
			}
		}
		return k;
	}

	private static List<Integer> palindromeFinder(int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			String text = String.valueOf(i);
			if (text.equals(new StringBuilder(text).reverse().toString())) {
				list.add(i);
			}
		}
		return list;
	}
}
