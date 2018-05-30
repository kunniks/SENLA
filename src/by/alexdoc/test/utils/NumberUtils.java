package by.alexdoc.test.utils;

public class NumberUtils {
	public static int userChoice(String line, int defaultValue) {
		try {
			return Integer.parseInt(line);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}

