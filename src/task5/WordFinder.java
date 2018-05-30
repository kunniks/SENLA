package task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Задание №5
Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
Текст и слово вводится вручную.
*/

public class WordFinder {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		String[] text = getTextAndWord();
		System.out.println("Слово (или сочетание) \"" + text[1] + "\" встречается в тексте " + findWord(text[0], text[1]) + " раз(а)");
	}

	private static int findWord(String t, String w) {
		// метод засчитывает не только совпадение слов, но и когда искомое слово встречается в тексте
		// как часть большого слова, например, "красн" в словах "прекрасный", "красный" и "покраснение"
		int count=0;
		if(!t.contains(w)) // проверим, может, слово не встречается?
			return count;

		t = t.toLowerCase();
		w = w.toLowerCase();
		int i = t.indexOf(w);

		while (i >= 0) {
			count++;
			i = t.indexOf(w, i + 1);
		}
		return count;
	}

	private static String[] getTextAndWord() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[2];
		System.out.println("Введите поочередно:\n" +
				"параметр №1 - любой текст, параметр №2 - любое слово для поиска в тексте");
		try {
			for (int i = 0; i < 2; i++) {
				while (true) {
					System.out.print("Введите параметр №" + (i+1) + ": ");
					input[i] = reader.readLine();
					if (input[i].isEmpty() || input[i].matches("\\s+"))
						System.out.println("Ошибка ввода - пустая строка. Попробуйте снова");
					else
						break;
				}
			}
		} catch(IOException e){
				System.out.println("Произошла ошибка. Проверьте введенные данные и попробуйте снова");
			}
		return input;
	}
}
