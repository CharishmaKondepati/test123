package in.string;

import java.util.Scanner;

public class SpecialChars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your value : ");
		String s = sc.nextLine();
		int alp = 0;
		int dig = 0;
		int spl = 0;
		
			for(int i=0;i<s.length();i++)
			{
				char ch=s.charAt(i);
	
			  if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') )
				{
					alp++;
				}
			  else if(ch>='0' && ch<='9')
			  {
				  dig++;
			  }
			  else
			  {
				  spl++;
			  }
			  
			}
			System.out.println("Number of special characters are : " + spl);
		  
		}

	}


