import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            final long MOD = 1000000007L;
            String s = x.next();
            int n = s.length();
            long ans = 0;
            long cntB = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'b') {
                    cntB++;
                } else {
                    ans = (ans + cntB) % MOD;
                }
            }
            out.println(ans);

            out.close();
        } catch (Exception e) {
            return;
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
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }

    static class FastWriter {
        BufferedWriter bw;
        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        void print(Object obj) { bw.write(obj.toString()); }
        void println(Object obj) { bw.write(obj.toString() + "\n"); }
        void close() { try { bw.close(); } catch (IOException e) {} }
    }
}
