package selenium;

import java.util.Arrays;

import org.openqa.selenium.By;

public class SortPractice0821 {

	public static void main(String[] args) {

		int numbers[] = { 22, 57, 89, 39, 64, 102, 75, 82, 41, 17 };
		bubbleSort(numbers);
	}

	public static void bubbleSort(int[] input) {
		for (int j = 0; j < input.length; j++)
			for (int i = 0; i < input.length - 1; i++) {
				System.out.println("term is " + (j + 1) + "-" + (i + 1));
				if (input[i] > input[i + 1]) {
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
				}
				System.out.println(Arrays.toString(input));
			}
	}

}
