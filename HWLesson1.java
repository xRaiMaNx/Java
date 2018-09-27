import java.util.Random;

/**
 * Java. Level 2. Lesson 1
 *
 * @author Maxim Silenin
 * @version dated Sep 27 2018
 */

class HWlesson1 {
	public static void main(String[] args) {
		Course c = new Course();
		Team team = new Team("Shariki");
		c.printInformationAboutObstacle();
		team.printInformationAboutTeam();
		c.doIt(team);
		team.showResults();
	}
}

abstract class Animal {
	protected String name;
	protected boolean passing;
	
	public abstract String voice();
	
	public void setPassing(boolean passing1, boolean passing2) {
		this.passing = passing1 & passing2 ;
	}
}

interface Runable {
	boolean run(int length);
	int getRunLimit();
}	

interface Swimable {
	boolean swim(int length);
	int getSwimLimit();
}

// Cat
class Cat extends Animal implements Runable, Swimable {
	private final int max_run_limit = 100;
	private final int max_swim_limit = 15;
	private int run_limit;
	private int swim_limit;
	
	public Cat(String name) {
		this.name = name;
		run_limit = max_run_limit;
		swim_limit = max_swim_limit;
	}
	
	public Cat(String name, int run_limit, int swim_limit) {
		this.name = name;
		if(run_limit <= max_run_limit)
			this.run_limit = run_limit;
		else 
			this.run_limit = max_run_limit;
		if(swim_limit <= max_swim_limit)
			this.swim_limit = swim_limit;
		else
			this.swim_limit = max_swim_limit;
	}
	
	public boolean run(int length) {
		return run_limit >= length;
	}
	
	public int getRunLimit() {
		return run_limit;
	}
	
	public boolean swim(int length) {
		return swim_limit >= length;
	}
	
	public int getSwimLimit() {
		return swim_limit;
	}
	
	public String voice() {
		return "Voice: meow";
	}
}	

// Dog
class Dog extends Animal implements Runable, Swimable {
	private final int max_run_limit = 200;
	private final int max_swim_limit = 25;
	private int run_limit;
	private int swim_limit;
	
	public Dog(String name) {
		this.name = name;
		run_limit = max_run_limit;
		swim_limit = max_swim_limit;
	}
	
	public Dog(String name, int run_limit, int swim_limit) {
		this.name = name;
		if(run_limit <= max_run_limit)
			this.run_limit = run_limit;
		else 
			this.run_limit = max_run_limit;
		if(swim_limit <= max_swim_limit)
			this.swim_limit = swim_limit;
		else
			this.swim_limit = max_swim_limit;
	}
	
	public boolean run(int length) {
		return run_limit >= length;
	}
	
	public int getRunLimit() {
		return run_limit;
	}
	
	public boolean swim(int length) {
		return swim_limit >= length;
	}
	
	public int getSwimLimit() {
		return swim_limit;
	}
	
	public String voice() {
		return "Voice: woof woof";
	}
}

// Fish
class Fish extends Animal implements Swimable {
	private final int max_swim_limit = 100;
	private int swim_limit;
	
	public Fish(String name) {
		this.name = name;
		swim_limit = max_swim_limit;
	}
	
	public Fish(String name, int swim_limit) {
		this.name = name;
		if(swim_limit <= max_swim_limit)
			this.swim_limit = swim_limit;
		else
			this.swim_limit = max_swim_limit;
	}
	
	public boolean swim(int length) {
		return swim_limit >= length;
	}
	
	public int getSwimLimit() {
		return swim_limit;
	}
	
	public String voice() {
		return "Voice: -";
	}
}

// Hen
class Hen extends Animal implements Runable {
	private final int max_run_limit = 50;
	private int run_limit;
	
	public Hen(String name) {
		this.name = name;
		run_limit = max_run_limit;
	}
	
	public Hen(String name, int run_limit) {
		this.name = name;
		if(run_limit <= max_run_limit)
			this.run_limit = run_limit;
		else 
			this.run_limit = max_run_limit;
	}
	
	public boolean run(int length) {
		return run_limit >= length;
	}
	
	public int getRunLimit() {
		return run_limit;
	}
	
	public String voice() {
		return "Voice: ko-ko-ko";
	}
}

// Team of animals
// #2
class Team {
    private String nameTeam;
	private int points = 0;
	Animal[] animals = {new Cat("Murzik"), new Cat("Boris", 75, 20), new Hen("Zlata"), new Fish("Rick"), new Dog("Bobik"), new Dog("Rich", 150, 30)};
    public Animal[] members = new Animal[4];
	Random random = new Random();
	public Team(String nameTeam) {
		this.nameTeam = nameTeam;
		for(int i = 0; i < 4; i++) {
			int ran = random.nextInt(6);
			members[i] = animals[ran];
		}
	}
	
	public void printInformationAboutTeam() {
		System.out.println("Team: " + nameTeam);
		for(int i = 0; i < 4; i++) {
			System.out.println((i+1) + " Member: " + members[i].name);
			if(members[i] instanceof Runable)
				System.out.println("Run limit: " + ((Runable) members[i]).getRunLimit());
			if(members[i] instanceof Swimable)
				System.out.println("Swim limit: " + ((Swimable) members[i]).getSwimLimit());
			members[i].voice();
			System.out.println();
		}
	}
	
	public void showResults() {
		System.out.println(nameTeam + ": ");
		for(int i = 0; i < 4; i++) {
			if(members[i].passing) {
				System.out.println(members[i].name + ": " + members[i].passing + " +1");
				points++;
			}
			else
				System.out.println(members[i].name + ": " + members[i].passing + " +0");
		}
		System.out.println("Points: " + points);
	}
}

// interface for Track and WaterWay
interface InterfaceForStrips {
	public boolean passDistance(Animal animal);
	public int getLength();
}

// 1st obstacle strip
class Track {
	private int length;
	
	public Track(int length) {
		this.length = length;
	}
	
	public boolean passDistance(Animal animal) {
		if(animal instanceof Runable)
			return ((Runable) animal).run(length);
		return false;
	}
	
	public int getLength() {
		return length;
	}
}

// 2nd obstacle strip
class WaterWay {
	private int length;
	
	public WaterWay(int length) {
		this.length = length;
	}
	
	public boolean passDistance(Animal animal) {
		if(animal instanceof Swimable)
			return ((Swimable)animal).swim(length);
		return false;
	}
	
	public int getLength() {
		return length;
	}
}

// Obstacle strips
// #3
class Course {
	private Track track;
	private WaterWay waterWay;
	
	Random random = new Random();
	public Course() {
		track = new Track(random.nextInt(100));
		waterWay = new WaterWay(random.nextInt(20));
	}
	
	public void printInformationAboutObstacle() {
        System.out.println("Length track: " + track.getLength());
        System.out.println("Length waterway: " + waterWay.getLength());
        System.out.println();
    }
	
	public void doIt(Team team) {
		for(Animal a : team.members) {
			a.setPassing(track.passDistance(a), waterWay.passDistance(a));
		}
	}
}