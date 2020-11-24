import java.util.Scanner;

public class BinarySearchDemo {
	public static void main (String[] args) {
		int result, searchValue;
		
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		for(int i : arr) {
			System.out.print(i);
		}
		System.out.println();
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the searchValue");
		searchValue = reader.nextInt();

		result = binarySearch(arr, searchValue);
		if (result == -1) {
			System.out.println(searchValue + " was not found");
		} else {
			System.out.println(searchValue + " was found");
		}
		
	}
	public static int binarySearch(int[] number, int value) {
		int first;
		int last;
		int position;
		int middle;
		//boolean found;
		
		first = 0;
		last = number.length - 1;
		position = -1;
		
		while(first <= last ) {
			middle = (first + last) / 2;
			if(number[middle] == value) {
				//found = true;
				position = middle;
				break;
			} else if(number[middle] > value) {
				last = middle - 1;
			} else {
				first = middle + 1;
			}
		}		
		return position;
	}
}
