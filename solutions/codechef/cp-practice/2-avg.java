import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(); 

        while (t-- > 0) { 
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            
            double avg = (a + b)/2.0;
            
            if(avg > c){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }

	}
}
