import java.io.*;
import java.util.*;

public class Solution {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        
        while (testCases-- > 0) {
            int size = Integer.parseInt(reader.readLine());
            
            int[] values = new int[size + 1];
            int[] frequency = new int[size + 1];
            String[] valueInput = reader.readLine().split(" ");
            for (int i = 1; i <= size; i++) {
                values[i] = Integer.parseInt(valueInput[i - 1]);
                frequency[values[i]]++;
            }
            
            List<List<Integer>> adjacencyList = new ArrayList<>(size + 1);
            for (int i = 0; i <= size; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            
            for (int i = 1; i < size; i++) {
                String[] edge = reader.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
            
            String result = processGraph(size, values, frequency, adjacencyList);
            writer.println(result);
        }
        
        writer.flush();
    }
    
    private static String processGraph(int size, int[] values, int[] frequency, 
                                    List<List<Integer>> adjacencyList) {
        boolean[] isValid = new boolean[size + 1];
        
        for (int u = 1; u <= size; u++) {
            for (int v : adjacencyList.get(u)) {
                if (u < v && values[u] == values[v]) {
                    isValid[values[u]] = true;
                }
            }
        }
        
        for (int u = 1; u <= size; u++) {
            if (adjacencyList.get(u).size() < 2) {
                continue;
            }
            
            Map<Integer, Integer> neighborValueCount = new HashMap<>();
            for (int v : adjacencyList.get(u)) {
                neighborValueCount.merge(values[v], 1, Integer::sum);
            }
            
            for (Map.Entry<Integer, Integer> entry : neighborValueCount.entrySet()) {
                if (entry.getValue() >= 2) {
                    isValid[entry.getKey()] = true;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int x = 1; x <= size; x++) {
            result.append(frequency[x] >= 2 && isValid[x] ? '1' : '0');
        }
        
        return result.toString();
    }
}
