import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.StringTokenizer;

public class C2 {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                int n = x.nextInt();
                long[] a = new long[n];
                for (int i = 0; i < n; i++) a[i] = x.nextLong();

                PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
                long total = 0;

                for (int i = 0; i < n; i++) {
                    if (a[i] == 0) {
                        long def = pq.isEmpty() ? 0 : pq.poll();
                        // damage for this dragon assumed to be next value equal pattern not needed
                    } else {
                        pq.add(a[i]);
                    }
                }

                out.println(total);
            }

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
