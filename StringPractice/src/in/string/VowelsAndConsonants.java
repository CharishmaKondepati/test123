package in.string;

import java.util.Scanner;

public class VowelsAndConsonants {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your value : ");
		String s = sc.nextLine();
		int vow = 0;
		int con = 0;
		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if( ( (ch == 'a') || (ch == 'e') || (ch == 'i')  || (ch == 'o') || (ch == 'u')) || 
					( (ch == 'A') || (ch == 'E') || (ch == 'I')  || (ch == '0') || (ch == 'U')))
			{
				vow++;
			}
			else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') )
			{
				con++;
			}
		  
		}
		
		System.out.println("No of vowels in the string are : " + vow);
		System.out.println("No of consonants in the string are : " + con);
		

	}

}
