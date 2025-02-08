import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  
        int k = sc.nextInt();  
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        

        List<Integer> window = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            window.add(arr[i]);
        }
        
        Collections.sort(window);
        
        List<Long> result = new ArrayList<>();
        
        result.add(calculateCost(window));
        
        for (int i = k; i < n; i++) {
            window.remove(Integer.valueOf(arr[i - k]));
            
            window.add(arr[i]);
            
            Collections.sort(window);
            
            result.add(calculateCost(window));
        }
        
        for (long cost : result) {
            System.out.print(cost + " ");
        }
    }
    
    private static long calculateCost(List<Integer> window) {
        int median = window.get(window.size() / 2); 
        long totalCost = 0;
        
        for (int value : window) {
            totalCost += Math.abs(value - median);
        }
        
        return totalCost;
    }
}

