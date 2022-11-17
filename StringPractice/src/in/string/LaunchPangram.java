package in.string;

import java.util.Arrays;
import java.util.Scanner;

public class LaunchPangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner in = new Scanner(System.in);
		 
	    System.out.println("Enter string:");
	    String str= in.nextLine();
	 
	    //Array to store counts of 26 alphbets
	    int count[] = new int[26];
	    boolean panagram = true;        //Assuming sentence is pangram
	    char ch;
	 
	    //Loop through each character of a string
	    for(int i=0; i<str.length(); i++){
	        ch = str.charAt(i);
	        
	        if(ch == ' ')
	        continue;
	        
	        /*
	          *check if the character is among 26 alphabets, If so
	          *then increment the count of their respective index position
	          'A'-'A' = 0
	          'B'-'A' = 1
	          'b'-'a' = 1
	          'c'-'a' = 2
	         */
	        if(ch>='A' && ch<='Z'){
	            count[ch-'A']++;      
	        } else if(ch>='a' && ch<='z'){
	            count[ch-'a']++;      
	        }
	 
	    }
	 
	    //checking if count array has any zeros
	    for(int i=0; i<count.length; i++){
	      if(count[i] == 0){
	        panagram = false;    //Not Pangram so break
	        break;
	      }
	    }
	 
	    if(panagram)
	      System.out.println("Pangram");
	    else 
	      System.out.println("Not a Pangram");
	 
	  }
		
		
		

	}


