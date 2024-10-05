import java.util.* ;
import java.io.*; 

public class Solution {
  public static int sumOfMaxMin(int[] arr, int n) {
      // Write your code here.
      Arrays.sort(arr);

      return arr[0] + arr[n-1];
  }
}