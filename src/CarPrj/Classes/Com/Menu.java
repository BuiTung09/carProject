package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static <E> int int_getChoice(ArrayList<E> options) {
		Scanner sc = new Scanner(System.in);
		int response;
		int N = options.size();
		for (int i = 0; i < N; i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
		do {
			System.out.println("Please choose an option (1-" + N + "): ");
			response = sc.nextInt();
			if (response == 12) {
				return response;
			}
		} while (response < 1 || response > N);
		return response;
	}

	public static <E> E ret_getChoice(ArrayList<E> option) {
		int response;
		int N = option.size();
		do {
			response = int_getChoice(option);
		} while (response < 1 || response > N);
		return option.get(response - 1);
	}
}
