import static java.lang.Integer.parseInt;

class HWLesson2 {
	public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
		String[][] arr = {{"10A", "20"}, {"30", "40B"}, {"BFA", "1001"}};
		checkArray(arr);
	}
	
	static void checkArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
		try {
			if(arr.length != 4 && arr[0].length != 4)
				throw new MyArraySizeException();
		}
		catch(MyArraySizeException e) {}
		int amount = 0, ind_i = 1, ind_j = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				try {
					ind_i = i;
					ind_j = j;
					amount += parseInt(arr[i][j]);
					
				}
				catch(NumberFormatException e) {
					try {
						throw new MyArrayDataException(ind_i, ind_j);
					}
					catch(MyArrayDataException ex) {}
				}
			}
		}
		System.out.println("Sum: " + amount);
	}
}

class MyArraySizeException extends Exception {
	MyArraySizeException() {
		System.out.println("It isn't the unsuitable size of the array");
	}
}

class MyArrayDataException extends Exception {
	MyArrayDataException(int ind_i, int ind_j) {
		System.out.println("In the cell is not a number, a cell index [" + ind_i + "] [" + ind_j + "]");
	}
}