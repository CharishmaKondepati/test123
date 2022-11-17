package in.string;

import java.util.Arrays;
import java.util.Scanner;

public class LaunchAnagram {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter string 1:");
		String s1 = scan.nextLine();
		System.out.println("Enter string 2:");
		String s2 = scan.nextLine();

		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();

		if (c1.length != c2.length) {
			System.out.println("Not Anagram");
			System.exit(0);
		}

		Arrays.sort(c1);
		Arrays.sort(c2);

		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				System.out.println("Not Anagram");
				System.exit(0);
			}
		}
		System.out.println("Anagram");

	}

}
