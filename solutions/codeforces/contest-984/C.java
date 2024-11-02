import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt();

            while (t-- > 0) {
                StringBuilder s = new StringBuilder(x.nextLine());
                int q = x.nextInt();
                BitSet indices = new BitSet();

                for (int i = 0; i <= s.length() - 4; i++) {
                    if (s.substring(i, i + 4).equals("1100")) {
                        indices.set(i);
                    }
                }

                while (q-- > 0) {
                    int i = x.nextInt() - 1;
                    int v = x.nextInt();
                    s.setCharAt(i, (char) (v + '0'));

                    for (int j = Math.max(0, i - 3); j <= Math.min(s.length() - 4, i); j++) {
                        checkForSubstring1100(indices, s, j);
                    }

                    out.println(indices.isEmpty() ? "NO" : "YES");
                }
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }

    private static void checkForSubstring1100(BitSet indices, StringBuilder s, int pos) {
        if (pos >= 0 && pos + 3 < s.length() && s.substring(pos, pos + 4).equals("1100")) {
            indices.set(pos);
        } else {
            indices.clear(pos);
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
