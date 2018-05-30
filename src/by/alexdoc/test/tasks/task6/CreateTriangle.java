package by.alexdoc.test.tasks.task6;

import by.alexdoc.test.tasks.Task;

import java.util.Scanner;

/* Задание №6.
Написать программу, которая проверяет три отрезка на возможность
создать прямоугольный треугольник. Длина отрезков вводится вручную.
 */
public class CreateTriangle implements Task {

	@Override
	public void start() {
		double[] num = inputNum();
		// проверка на треугольник в принципе, если ок - проверка на прямоугольный треугольник
		if (isTriangle(num)) {
			System.out.print("Прямоугольный треугольник со сторонами ");
			for (int i = 0; i < 3; i++) {
				System.out.print(num[i] + " ");
			}
			if (isRightTriangle(num))
				System.out.println("можно построить");

			else
				System.out.println("нельзя построить");
		} else
			System.out.println("Из отрезков заданной вами длины невозможно построить треугольник");
	}

	private static boolean isRightTriangle(double[] d) {
		return ((d[0] * d[0]) == (d[1] * d[1]) + (d[2] * d[2]) || (d[1] * d[1]) == (d[0] * d[0]) + (d[2] * d[2])
				|| (d[2] * d[2]) == (d[0] * d[0]) + (d[1] * d[1]));
	}

	private static boolean isTriangle(double[] d) {
		return !(d[0] > (d[1] + d[2])) && !(d[1] > (d[0] + d[2])) && !(d[2] > (d[1] + d[0]));
	}

	private static double[] inputNum() {
		double array[] = new double[3];
		double k;
		System.out.println("Задайте поочередно длины трех отрезков " +
				"(принимаются любые положительные числа, точка - разделитель дробной части)");
		Scanner input = new Scanner(System.in);
		for (int i = 1; i < 4; i++) {
			while (true) {
				System.out.print("Введите длину " + i + "-ого отрезка из 3-х): ");
				try {
					k = Double.parseDouble(input.nextLine());
					if (k > 0)
						break;
					else
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					System.out.println("Ошибка! Принимаются только положительные числа. Попробуйте снова.");
				}
			}
			array[i - 1] = k;
		}
		return array;
	}
}
