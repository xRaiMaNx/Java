/**
* Homework. Java 1. Lesson 6.
*
*@author Maxim Silenin
*@version Aug 30 2018
*/

abstract class Animal {
	private final int max_run_length = 0;
	private final double max_jump_height = 0;
	private final int max_swim_length = 0;
	
	abstract void run(int length);
	
	abstract void jump(double height);
	
	abstract void swim(int length);
}

class Cat extends Animal {
	private final int max_run_length = 200;
	private final double max_jump_height = 2;
	
	@Override
	void run(int length) {
		if(length >= 0 && length <= max_run_length) System.out.println("run: true");
		else System.out.println("run: false");
	}
	
	@Override
	void jump(double height) {
		if(height >= 0 && height <= max_jump_height) System.out.println("jump: true");
		else System.out.println("jump: false");
	}
	
	@Override
	void swim(int length) {
		System.out.println("swim: false");
	}
}

class Dog extends Animal {
	private final int max_run_length = 500;
	private final double max_jump_height = 0.5;
	private final int max_swim_length = 10;
	
	@Override
	void run(int length) {
		if(length >= 0 && length <= max_run_length) System.out.println("run: true");
		else System.out.println("run: false");
	}
	
	@Override
	void jump(double height) {
		if(height >= 0 && height <= max_jump_height) System.out.println("jump: true");
		else System.out.println("jump: false");
	}
	
	@Override
	void swim(int length) {
		if(length >= 0 && length <= max_swim_length) System.out.println("swim: true");
		else System.out.println("swim: false");
	}
}

class HWLesson6 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.run(100);
		cat.jump(3);
		cat.swim(1);
		
		System.out.println();
		
		Dog dog = new Dog();
		dog.run(559);
		dog.jump(0.1);
		dog.swim(7);
	}
}