import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        final int MAX_V = 400005;
        int[] countV = new int[MAX_V];

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] ranges = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                ranges[i][0] = Integer.parseInt(line[0]);
                ranges[i][1] = Integer.parseInt(line[1]);
            }

            Map<Integer, Integer> freqFixed = new HashMap<>();
            for (int[] range : ranges) { 
                if (range[0] == range[1]) {
                    freqFixed.put(range[0], freqFixed.getOrDefault(range[0], 0) + 1);
                }
            }

            int[] uniqueFixed = freqFixed.keySet().stream().mapToInt(i -> i).toArray();
            Arrays.sort(uniqueFixed);

            for (int key : freqFixed.keySet()) {
                countV[key] += freqFixed.get(key);
            }

            StringBuilder s = new StringBuilder();
            for (int[] range : ranges) {
                int li = range[0];
                int ri = range[1];

                if (li < ri) {
                    int lower = lowerBound(uniqueFixed, li);
                    int upper = upperBound(uniqueFixed, ri);
                    int numFixed = upper - lower;
                    int size = ri - li + 1;
                    s.append(numFixed < size ? '1' : '0');
                } else {
                    int v = li;
                    s.append(countV[v] <= 1 ? '1' : '0');
                }
            }

            bw.write(s.toString());
            bw.newLine();

            for (int key : freqFixed.keySet()) {
                countV[key] -= freqFixed.get(key);
            }
        }

        bw.flush();
    }

    private static int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
