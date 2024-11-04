import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt();
            while (t-- > 0) {
                long l = x.nextLong();
                long r = x.nextLong();
                long i = x.nextLong();
                long k = x.nextLong();

                long m = 1L << i; 
                long t_start = (l > k) ? (l - k + m - 1) / m : 0;
                long t_end = (r >= k) ? (r - k) / m : -1;

                long XOR_k = 0;

                if (t_start <= t_end) {
                    long c = t_end - t_start + 1;
                    long xor_t_end = computeXor(t_end);
                    long xor_t_start_minus_1 = computeXor(t_start - 1);
                    long xor_t = xor_t_end ^ xor_t_start_minus_1;
                    xor_t <<= i; 

                    if (c % 2 == 1) {
                        XOR_k = xor_t ^ k; 
                    } else {
                        XOR_k = xor_t;
                    }
                }

                long xor_r = computeXor(r);
                long xor_l_minus_1 = computeXor(l - 1);
                long XOR_total = xor_r ^ xor_l_minus_1;
                long XOR_non_k = XOR_total ^ XOR_k;

                out.println(XOR_non_k);
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }

    private static long computeXor(long n) {
        if (n < 0) return 0;
        long rem = n % 4;
        if (rem == 0) return n;
        if (rem == 1) return 1;
        if (rem == 2) return n + 1;
        return 0;
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
