import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            String s = x.next();
            int zeroCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroCount++;
            }
            int oneCount = s.length() - zeroCount;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zeroCount; i++) sb.append('0');
            for (int i = 0; i < oneCount; i++) sb.append('1');
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
