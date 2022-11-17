package in.string;

import java.util.Arrays;
import java.util.Scanner;

public class SortingStringValues {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your String :");
		String s1 = scan.nextLine();
		
		char ch[] = s1.toCharArray();
		
		Arrays.sort(ch);
		System.out.println("Alphabetically sorted string is :");
		System.out.println(ch);

	}

}
