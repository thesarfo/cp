import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                long a = x.nextLong();
                long b = x.nextLong();
                long l = x.nextLong();

                HashSet<Long> set = new HashSet<>();
                long ax = 1;
                while (ax <= l) {
                    if (l % ax == 0) {
                        long rem = l / ax;
                        long by = 1;
                        while (by <= rem) {
                            if (rem % by == 0) {
                                set.add(rem / by);
                            }
                            by *= b;
                        }
                    }
                    ax *= a;
                }
                sb.append(set.size()).append("\n");
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
