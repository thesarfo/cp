import java.io.*;
import java.util.*;

public class Main {

    static Pair computeLucky(long left, long right, int threshold) {
        if (right - left + 1 < threshold)
            return new Pair(0, 0);
        if (right - left + 1 == 1)
            return new Pair(left, 1);
        long mid = left + (right - left) / 2;
        if ((right - left + 1) % 2 == 1) {
            Pair leftResult = computeLucky(left, mid - 1, threshold);
            long totalLucky = mid + 2 * leftResult.first + mid * leftResult.second;
            int totalSegments = 2 * leftResult.second + 1;
            return new Pair(totalLucky, totalSegments);
        } else {
            Pair leftResult = computeLucky(left, mid, threshold);
            long totalLucky = 2 * leftResult.first + mid * leftResult.second;
            int totalSegments = 2 * leftResult.second;
            return new Pair(totalLucky, totalSegments);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            String[] inputs = br.readLine().split(" ");
            long n = Long.parseLong(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            Pair result = computeLucky(1, n, k);
            bw.write(result.first + "\n");
        }
        bw.flush();
    }

    static class Pair {
        long first;
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
