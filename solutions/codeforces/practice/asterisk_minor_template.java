import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                String pattern = x.next();
                int n = x.nextInt();

                boolean[] isMinor = new boolean[26];
                int starPos = -1;
                for (int i = 0; i < pattern.length(); i++) {
                    char c = pattern.charAt(i);
                    if (c == '*') {
                        starPos = i;
                    } else {
                        isMinor[c - 'a'] = true;
                    }
                }
                String prefix = starPos == -1 ? pattern : pattern.substring(0, starPos);
                String suffix = starPos == -1 ? "" : pattern.substring(starPos + 1);

                for (int i = 0; i < n; i++) {
                    String s = x.next();
                    boolean ok = true;

                    if (starPos == -1) {
                        if (!s.equals(pattern)) ok = false;
                    } else {
                        if (s.length() < prefix.length() + suffix.length()) {
                            ok = false;
                        } else {
                            if (!s.substring(0, prefix.length()).equals(prefix)) ok = false;
                            if (ok && !s.substring(s.length() - suffix.length()).equals(suffix)) ok = false;
                        }
                    }

                    if (ok) {
                        for (int j = 0; j < 26 && ok; j++) {
                            if (isMinor[j]) {
                                boolean found = false;
                                for (int k = 0; k < s.length(); k++) {
                                    if (s.charAt(k) - 'a' == j) { found = true; break; }
                                }
                                if (!found) ok = false;
                            }
                        }
                    }

                    sb.append(ok ? "YES" : "NO").append('\n');
                }
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
