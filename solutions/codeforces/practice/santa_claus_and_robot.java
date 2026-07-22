import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            long px = x.nextLong();
            long py = x.nextLong();

            StringBuilder sb = new StringBuilder();

            char horiz = px >= 0 ? 'R' : 'L';
            char vert = py >= 0 ? 'U' : 'D';

            long ax = Math.abs(px);
            long ay = Math.abs(py);

            for (long i = 0; i < ax; i++) sb.append(horiz);
            for (long i = 0; i < ay; i++) sb.append(vert);

            out.println(ax + ay);
            out.println(sb.toString());

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
