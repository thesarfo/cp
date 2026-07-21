import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int n = x.nextInt();
            int k = x.nextInt();
            int[] cnt = new int[6];
            for (int i = 0; i < n; i++) {
                int t = x.nextInt();
                cnt[t]++;
            }

            int groups = Math.min(cnt[3], cnt[4]);
            cnt[3] -= groups;
            cnt[4] -= groups;

            int total = groups;
            total += cnt[4];

            int rem1 = cnt[1];
            int use3 = cnt[3];
            total += use3;
            int need1for3 = use3;
            if (rem1 >= need1for3) {
                rem1 -= need1for3;
            } else {
                rem1 = 0;
            }

            total += cnt[2] / 2;
            rem1 += (cnt[2] % 2) * 2;

            total += rem1 / 4;

            if (total >= k) {
                out.println("YES");
            } else {
                out.println("NO");
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
