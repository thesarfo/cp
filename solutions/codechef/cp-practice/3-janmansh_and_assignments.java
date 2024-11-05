import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0){
		    int x = sc.nextInt();
		    if((x + 3) <= 10){
		        System.out.println("Yes");
		    } else{
		        System.out.println("No");
		    }
		}

	}
}
