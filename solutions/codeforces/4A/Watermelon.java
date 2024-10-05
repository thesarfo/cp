import java.util.*;
import java.io.*;

public class Watermelon {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);

        int w = reader.nextInt();
        solve(w, writer);

        writer.flush();
        writer.close();
    }

    private static void solve(int w, PrintWriter writer) {
        if (w > 2 && w % 2 == 0) {
            writer.println("YES");
        } else {
            writer.println("NO");
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
