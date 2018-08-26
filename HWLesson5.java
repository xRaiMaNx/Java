/**
* Homework. Java 1. Lesson 3.
*
*@author Maxim Silenin
*@version Aug 26 2018
*/

class HWLesson5 {
	public static void main(String[] args) {
		// #4
		Employee[] employeeArray = new Employee[5];
		employeeArray[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer", "ivivan@mailbox.com", 892312312, 30000, 30);
		employeeArray[1] = new Employee("Maximov Maxim Maximovich", "Programmer", "mmmaxim@gmail.com", 892323423, 35000, 41);
		employeeArray[2] = new Employee("Petrov Petr Petrovich", "Banker", "petrov_bank@mail.ru", 892334534, 40000, 25);
		employeeArray[3] = new Employee("Semenov Semen Semenovich", "Manager", "semensemenov@rambler.ru", 892345645, 20000, 48);
		employeeArray[4] = new Employee("Petrov Maxim Olegovich", "Cashier", "mopetr@gmail.com", 892356756, 23000, 52);
		// #5
		for (Employee e : employeeArray) 
			if (e.getAge() > 40) 
				e.printFullInfo();
	}
}

// #1
class Employee {
	private String full_name, position, email;
	private int phone_number, salary, age;
	
	// #2
	Employee(String full_name,
			 String position,
			 String email,
			 int phone_number,
			 int salary,
			 int age) {
		this.full_name = full_name;
		this.position = position;
		this.email = email;
		this.phone_number = phone_number;
		setSalary(salary);
		setAge(age);
	}
	
	// #3
	void printFullInfo() {
		System.out.println("Full name: " + full_name + "\n"
						   + "Position: " + position + "\n"
						   + "Email: " + email + "\n"
						   + "Phone number: " + phone_number + "\n"
						   + "Salary: " + salary + "\n"
						   + "Age: " + age + "\n");
	}
	
	// #6
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}
	
	void setSalary(int salary) {
		if (salary > 0) {
			this.salary = salary;
		}
	}
}