import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt();

            while (t-- > 0) {
                int n = x.nextInt();
                String s = x.next();
                String r = x.next();

                ArrayList<Character> sc = new ArrayList<>();
                int p = 0;

                for (char c : s.toCharArray()) {
                    sc.add(c);

                    while (sc.size() >= 2 &&
                            sc.get(sc.size() - 2) != sc.get(sc.size() - 1) &&
                            p < r.length()) {
                        char rpt = r.charAt(p);
                        sc.remove(sc.size() - 1);
                        sc.remove(sc.size() - 1);
                        sc.add(rpt);
                        p++;
                    }
                }

                if (p == n - 1 && sc.size() == 1) {
                    out.println("YES");
                } else {
                    out.println("NO");
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