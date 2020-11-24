import java.util.Scanner;

public class SequentialSearch {
	public static void main(String [] args) {
		int number;
		int result;
		int number2;
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number you want to find.");
		number = keyboard.nextInt();
		
		result = search(arr, number);
		
		if(result == -1) {
			System.out.println(number + " was not found.");
		} else {
			System.out.println(number + " was found.");
		}
		
		Scanner reader = new Scanner(System.in);
		System.out.println("2. Enter the number you want to find.");
		number2 = reader.nextInt();

		result = binarySearch(arr, number2);
		if (result == -1) {
			System.out.println(number2 + " was not found");
		} else {
			System.out.println(number2 + " was found");
		}
		
	}
	public static int search(int values[], int searchValue) {
		int position;
		int n;
		int initial;
		int counter;
		boolean found;
		
		n = values.length - 1;
		found = false;
		position = -1;
		initial = 0;
		counter = 0;
		
		while(!found && initial <= n ) {
			if(values[initial] == searchValue) {
				position = searchValue;
				counter ++;
				found = true;
			} else {
				initial ++;
				counter ++;
			}
		}
		System.out.println("Number of Comparisons: " + counter);
		return position;
	}
	public static int binarySearch(int[] number, int value) {
		int first;
		int last;
		int position;
		int middle;
		int counter;
		boolean found;
		
		first = 0;
		last = number.length - 1;
		position = -1;
		found = false;
		counter = 0;
		
		while(!found && first <= last ) {
			middle = (first + last) / 2;
			if(number[middle] == value) {
				counter ++;
				found = true;
				position = middle;
			} else if(number[middle] > value) {
				counter ++;
				last = middle - 1;
			} else {
				counter ++;
				first = middle + 1;
			}
		}
		System.out.println("Number of Comparisons: " + counter);
		return position;
	}
}
