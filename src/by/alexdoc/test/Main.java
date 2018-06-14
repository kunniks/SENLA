package by.alexdoc.test;

import by.alexdoc.test.tasks.Task;
import by.alexdoc.test.tasks.task1.NumAnalyzer;
import by.alexdoc.test.tasks.task10.NumCombinator;
import by.alexdoc.test.tasks.task2.NumCalc;
import by.alexdoc.test.tasks.task3.PalindromeWord;
import by.alexdoc.test.tasks.task4.WordSorter;
import by.alexdoc.test.tasks.task5.WordFinder;
import by.alexdoc.test.tasks.task6.CreateTriangle;
import by.alexdoc.test.tasks.task7.ArrayGenerator;
import by.alexdoc.test.tasks.task8.PalindromeNum;
import by.alexdoc.test.tasks.task9.EvenNumCalc;

import by.alexdoc.test.utils.NumberUtils;

import java.util.Scanner;

/* Это основной класс данного проекта.
Он создан для того, чтобы облегчить проверку заданий (задания запускаются отсюда вводом номера задания).
Автор: Алейник Александр Вячеславович, г. Гродно
 */

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Task task = null;
		boolean exit = false;
		int i = 0;

		while (!exit) {
			System.out.print("Введите номер задания (целое число от 1 до 10 включительно): ");
			i = NumberUtils.userChoice(input.nextLine(), -1);

			switch (i) {
				case 1:
					task = new NumAnalyzer();
					exit = true;
					break;
				case 2:
					task = new NumCalc();
					exit = true;
					break;
				case 3:
					task = new PalindromeWord();
					exit = true;
					break;
				case 4:
					task = new WordSorter();
					exit = true;
					break;
				case 5:
					task = new WordFinder();
					exit = true;
					break;
				case 6:
					task = new CreateTriangle();
					exit = true;
					break;
				case 7:
					task = new ArrayGenerator();
					exit = true;
					break;
				case 8:
					task = new PalindromeNum();
					exit = true;
					break;
				case 9:
					task = new EvenNumCalc();
					exit = true;
					break;
				case 10:
					task = new NumCombinator();
					exit = true;
					break;
				default:
					System.out.println("Ошибка ввода! Нажмите [ctrl+c] для выхода или попробуйте снова.");
					break;
			}
		}
		System.out.println("Задание №" + i);
		task.start();
	}
}
