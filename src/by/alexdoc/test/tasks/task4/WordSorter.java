package by.alexdoc.test.tasks.task4;

import by.alexdoc.test.tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задание №4.
Создать программу, которая будет подсчитывать количество слов в предложении
и выводить их в отсортированном виде.
Предложение вводится вручную. (Разделители пробел (“ ”) и запятая (“,”)).
 */

public class WordSorter implements Task {

	@Override
	public void start() {
		// Забираем предложение
		System.out.print("Введите предложение: ");
		String text = getText();
		if (text == null)
			return;
		//Режем предложение на слова (замена всех знаков препинания на пробелы, перевод в нижний
		//регистр, подчищаем "хвосты" и режем)
		String[] words = text.replaceAll("[\\p{P}]", " ").toLowerCase().trim().split("\\s+");
		// Считаем, сортируем слова в алфавитном порядке и выводим на экран
		Arrays.sort(words); //TODO: Решить проблему с Ёж, Йод и т.д., изучив компаратор и смену локали
		System.out.println("В данном предложении " + words.length + " слов. В алфавитном" +
				" порядке:\n" + Arrays.toString(words));
	}

	private static String getText() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			System.out.println("Произошла ошибка. Проверьте введенные данные и попробуйте снова");
		}
		return input;
	}
}
