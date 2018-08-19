import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

/**
* Homework. Java 1. Lesson 3.
*
*@author Maxim Silenin
*@version Aug 19 2018
*/

class HWLesson3 {
	public static void main(String[] args) throws IOException {
		System.out.println("Здравствуйте! Меня зовут Боня");
		System.out.println("Сегодня мы поиграем в две игры. Первая игра называется 'Угадай число'");
		t1();
		System.out.println("Вторая игра называется 'Угадай слово'");
		t2();
	}
	
	// #1
	static void t1() throws IOException {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		boolean again = true;
		System.out.println("Я загадаю число, а вы должны будете его угадать.");
		System.out.println("У вас будет 3 попытки, чтобы угадать число.");
		System.out.println("Чтобы облегчить вашу задачу, я буду говорить вам больше или меньше ваше число по сравнению с моим.");
		while (again) {
			again = false;
			int hidden_number = random.nextInt(10);
			for (int i = 0; i < 3; i++) {
				System.out.print("Введите число: ");
				int number = scanner.nextInt();
				if (number == hidden_number) {
					System.out.println("Поздравляю, вы разгадали число! :)");
					break;
				}
				else if (i == 2) {
					System.out.println("К сожалению, вы проиграли. :(");
					System.out.println("Загаданное число: " + hidden_number);
					break;
				}
				else if (number > hidden_number)
					System.out.println("Ваше число больше моего");
				else
					System.out.println("Ваше число меньше моего");
			}
			again = repeat(scanner);
		}
	}
	
	static boolean repeat(Scanner scanner) throws IOException {
			System.out.println("Повторить игру еще раз? (1 - повторить, 0 - нет)");
			int answer = scanner.nextInt();
			if (answer == 1) {
				return true;
			}
			else if (answer == 0) {
				return false;
			}
			else {
				System.out.println("Некорректный ответ.");
				return repeat(scanner); // recursion
			}
	}
	
	// #2
	static void t2() throws IOException {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		String[] words = 
		{ "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
		"carrot","cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
        "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato" };
		int number = random.nextInt(25);
		String word = words[number];
		System.out.println("Я загадаю слово, а вы должны будете его угадать.");
		System.out.println("У вас есть неограниченное количество попыток.");
		System.out.print("Чтобы облегчить вашу задачу, я буду сравнивать ваше слово с моим, ");
		System.out.println("показывая какие буквы из вашего слова подходят к моему.");
		for ( ; ; ) {
			System.out.println("Введите слово:");
			String guess_word = scanner.nextLine();
			if (guess_word.compareTo(word) == 0) {
				System.out.println("Поздравляю, вы угадали! :)");
				break;
			}
			System.out.println("К сожалению, вы не угадали, вот сравнение вашего слова с моим:");
			System.out.println(guess_word);
			int n = 0;
			if (word.length() > guess_word.length())
				n = guess_word.length();
			else 
				n = word.length(); 
			for (int i = 0; i < n; i++) {
				if (guess_word.charAt(i) == word.charAt(i)) {
					System.out.print(word.charAt(i));
				}
				else {
					System.out.print("#");
				}
			}
			for(int i = 0; i < (15 - n); i++) {
				System.out.print("#");
			}
			System.out.println();
		}
	} 
}