package in.string;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatedStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your string : ");
		String s1 = scan.nextLine();
		int count = 0;
		
		 //Converts given string into character array    
        char ch[] = s1.toCharArray();    
            
        System.out.println("Duplicate characters in a given string: ");    
        //Counts each character present in the string    
        for(int i = 0; i <ch.length; i++) {    
            count = 1;    
            for(int j = i+1; j <ch.length; j++) {    
                if(ch[i] == ch[j] && ch[i] != ' ') {    
                    count++;    
                    //Set string[j] to 0 to avoid printing visited character    
                    ch[j] = '0';    
                }    
            }    
            //A character is considered as duplicate if count is greater than 1    
            if(count > 1 && ch[i] != '0')  
            {
            	 System.out.println(ch[i]);
            	 
            }
            
            	
        }    
       
        
			
		
	}

}
