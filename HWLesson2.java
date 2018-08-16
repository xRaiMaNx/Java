/**
* Homework. Java 1. Lesson 2.
*
*@author Maxim Silenin
*@version Aug 12 2018
*/

class HWLesson2 {
	public static void main(String[] args) {
		invertArray();
		fillArray();
		changeArray();
		fillDiagonal();
		findMininalAndMaximalElementOfArray();
		int[] a = {2, 1, 1, 2, 1};
		boolean check = checkBalance(a);
		System.out.println(check);
		int[] b = {1, 2, 3, 4, 5};
		int n = -3;
		b = shiftArray(b, n);
		outputtingArray(b);
	}
	
	// Method for outputting an array
	static void outputtingArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// #1
	static void invertArray() {
		int[] arr = { 1, 0, 1, 0, 0, 1 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				arr[i] = 0;
			}
			else {
				arr[i] = 1;
			}
		}
		outputtingArray(arr);
	}
	
	// #2
	static void fillArray() {
		int[] arr = new int[8];
		for (int i = 0, j = 0; i < 8; i++, j += 3) {
			arr[i] = j;
		}
		outputtingArray(arr);
	}
	
	// #3
	static void changeArray() {
		int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 6)
				arr[i] *= 2;
		}
		outputtingArray(arr);
	}
			
	// #4
	static void fillDiagonal() {
		int[][] arr = new int[4][4];
		for (int i = 0; i < 4; i++) {
			arr[i][i] = 1;
			arr[i][3 - i] = 1;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// #5
	static void findMininalAndMaximalElementOfArray() {
		byte[] array = {5, 5, 3, 4, 3, 2, 1};
		byte max = array[0], min = array[1];
		if (max < min) {
			max = min;
			min = array[0];
		}
		for (int i = 2; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				continue;
			}
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}
	
	// #6
	static boolean checkBalance(int[] arr) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < arr.length + 1; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) 
				return true;
        }
        return false;
    }	
	
	// #7
	static int[] shiftArray(int[] arr, int n) {
		if(n != 0){
			if (Math.abs(n) > arr.length)
				n %= arr.length;
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					int buffer = arr[0];
					arr[0] = arr[arr.length - 1];
					for (int j = 1; j < arr.length - 1; j++) {
						arr[arr.length - j] = arr[arr.length - j - 1];
					}
					arr[1] = buffer;
				}
			} 
			else if (n < 0) {
				for (int i = 0; i < Math.abs(n); i++) {
					int buffer = arr[arr.length - 1];
					arr[arr.length - 1] = arr[0];
					
					for (int j = 1; j < arr.length - 1; j++) {
						arr[j - 1] = arr[j];
					}
					
					arr[arr.length - 2] = buffer;
				}
			}
		}
		return arr;
	}	
}