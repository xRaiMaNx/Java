/**
* Homework. Java 1. Lesson 1.
*
*@author Maxim Silenin
*@version Aug 12 2018
*/

class HWLesson1 {
	// №2
	int a = 1;
	short b = 2;
	byte c = 3;
	long d = 4L;
	float e = 5.0f;
	double f = 6.0001;
	boolean g = true;
	char h = 'H';
	String i= "I'm Maxim";
	
	public static void main(String[] args) {
		System.out.println(calculatingResult(1, 2, 4, 4));
		System.out.println(trueOrFalse(5, 5));
		positiveOrNegative(0);
		System.out.println(checkForNegative(-2));
		hello("Maxim");
		checkYear(804);
	}
	
	// №3
	static int calculatingResult(int a, int b, int c, int d) {
		return a * (b + (c / d));
	}
	
	// №4
	static boolean trueOrFalse(int a, int b) {
		if ((a + b) >= 10 && (a + b) <= 20)
			return true;
		else
			return false;
	}
	
	// №5
	static void positiveOrNegative(int a) {
		if (a >= 0)
			System.out.println("Positive number!");
		else
			System.out.println("Negative number!");
	}
	
	// №6
	static boolean checkForNegative(int a) {
		if (a < 0)
			return true;
		return false;
	}
	
	// №7
	static void hello(String s) {
		System.out.println("Hello, " + s + "!");
	}
	
	// №8
	static void checkYear(int a) {
		if (a % 400 == 0 || a % 4 == 0 && a % 100 != 0)
			System.out.println("Leap-year");
		else
			System.out.println("Not leap-year");
	}
	
}