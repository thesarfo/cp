import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int n = x.nextInt();
            long[][] a = new long[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = x.nextLong();
                a[i][1] = i + 1;
            }

            java.util.Arrays.sort(a, (p, q) -> Long.compare(p[0], q[0]));

            long minDiff = Long.MAX_VALUE;
            for (int i = 0; i + 1 < n; i++) {
                long diff = a[i + 1][0] - a[i][0];
                if (diff < minDiff) minDiff = diff;
            }

            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i + 1 < n; i++) {
                long diff = a[i + 1][0] - a[i][0];
                if (diff == minDiff) {
                    sb.append((long) a[i][1]).append(' ').append((long) a[i + 1][1]).append('\n');
                    count++;
                }
            }

            out.println(minDiff + " " + count);
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
