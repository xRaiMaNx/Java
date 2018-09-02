/**
 * Java. Level 1. Lesson 7
 *
 * @author Maxim Silenin
 * @version dated Sep 02 2018
 */

class HWLesson7 {
    public static void main(String[] args) {
		// #5
		Cat[] cats = {new Cat("Matroskin", 5), new Cat("Murzik", 5), new Cat("Richi", 8)};
        Plate plate = new Plate(11);
		System.out.println("food in plate: " + plate);
        for (Cat c : cats) {
			c.eat(plate);
			System.out.println(c);
        }
		System.out.println("food in plate: " + plate);
		
		// #6
		plate.increaseFood(10);
		System.out.println("food in plate after increase food by 10: " + plate);
    }
}

class Cat {
    private String name;
    private int appetite;
	private boolean isFull; // #3
	

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
		isFull = false; // #3
    }

    void eat(Plate plate) {
		if(plate.getFood() >= appetite) { // #4
			plate.dicreaseFood(appetite);
			isFull = true; // #3
		}
    }
	
    @Override
    public String toString() {
        return name + " " + appetite + " " + isFull;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void dicreaseFood(int food) {
        this.food -= food;
		/*
		 	#2
		 	if(food >= this.food)
		 		this.food = 0;
		 	else
		 		this.food -= food;
		*/
    }
	
	int getFood() {
		return food;
	}
	
	@Override
    public String toString() {
        return "" + food;
    }
	
	// #6
	void increaseFood(int food) {
		this.food += food;
	}
}