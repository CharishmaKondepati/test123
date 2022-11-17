package in.string;

public class Launch2 {

	public static void main(String[] args) {
		
		String s1 = "Think Twice";
		String s2 ="";
		String s3 = "";
		
		String a[]=s1.split(" ");
		for(int i=a.length-1;i>=0;i--)
		{
			s2=s2+a[i]+" ";
			
		}
		
		for(int i=s1.length()-1;i>=0;i--)
		{
			s3=s3+s2.charAt(i);
		}
		System.out.println(s1);
		System.out.println(s3);
	

	}

}
