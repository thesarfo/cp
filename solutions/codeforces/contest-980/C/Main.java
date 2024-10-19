import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();
            int t = x.nextInt();

            while (t-- > 0) {
                int n = x.nextInt();
                String binaryString = x.next();

                // Check if Alice can win
                if (binaryString.charAt(0) == '1' || binaryString.charAt(n - 1) == '1') {
                    out.println("YES");
                } else {
                    boolean aliceCanWin = false;

                    // Check for consecutive '1's in the middle of the string
                    for (int i = 1; i < n - 1; i++) {
                        if (binaryString.charAt(i) == '1') {
                            if (binaryString.charAt(i - 1) == '1' || binaryString.charAt(i + 1) == '1') {
                                aliceCanWin = true;
                                break;
                            }
                        }
                    }

                    if (aliceCanWin) {
                        out.println("YES");
                    } else {
                        out.println("NO");
                    }
                }
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            if (System.getProperty("ONLINE_JUDGE") == null) {
                try {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
                } catch (Exception e) {
                }
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static class FastWriter {
        BufferedWriter bwr;

        public FastWriter() {
            bwr = new BufferedWriter(new OutputStreamWriter(System.out));
            if (System.getProperty("ONLINE_JUDGE") == null) {
                try {
                    bwr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
                } catch (Exception e) {
                }
            }
        }

        public void print(Object object) throws IOException {
            bwr.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bwr.append("\n");
        }

        public void close() throws IOException {
            bwr.close();
        }
    }
}
