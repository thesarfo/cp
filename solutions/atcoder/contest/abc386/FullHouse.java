import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] cards = new int[4];
        for (int i = 0; i < 4; i++) {
            cards[i] = sc.nextInt();
        }
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int card : cards) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        
        boolean possible = false;
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 3) {
                for (Map.Entry<Integer, Integer> other : freq.entrySet()) {
                    if (!other.getKey().equals(entry.getKey()) && other.getValue() == 1) {
                        possible = true;
                        break;
                    }
                }
            }
        }
        
        int pairs = 0;
        for (int count : freq.values()) {
            if (count == 2) pairs++;
        }
        if (pairs == 2) possible = true;
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 2) {
                if (freq.size() == 3) { 
                    possible = true;
                    break;
                }
            }
        }
        
        System.out.println(possible ? "Yes" : "No");
        sc.close();
    }
}