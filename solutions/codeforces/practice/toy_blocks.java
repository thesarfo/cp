import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();
            int t = x.nextInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                int n = x.nextInt();
                int k = x.nextInt();
                long[] a = new long[n];
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    a[i] = x.nextLong();
                    sum += a[i];
                }
                Arrays.sort(a);
                long ans = (sum + n - 1) / n;
                ans = Math.max(ans, a[k - 1]);
                sb.append(ans).append("\n");
            }
            out.print(sb.toString());
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
