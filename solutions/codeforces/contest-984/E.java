import java.io.*;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int n = x.nextInt();
            int k = x.nextInt();
            int q = x.nextInt();

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i <= k; i++) {
                res.add(new ArrayList<>(Collections.singletonList(0)));
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    int val = x.nextInt();
                    val = val | res.get(j).get(res.get(j).size() - 1);
                    res.get(j).add(val);
                }
            }

            while (q-- > 0) {
                int m = x.nextInt();
                List<Pair> lt = new ArrayList<>();
                List<Pair> gt = new ArrayList<>();

                for (int i = 0; i < m; i++) {
                    int r = x.nextInt();
                    char op = x.next().charAt(0);
                    int c = x.nextInt();
                    if (op == '<') {
                        lt.add(new Pair(r, c));
                    } else {
                        gt.add(new Pair(r, c));
                    }
                }

                int pos = 1;

                for (Pair pair : gt) {
                    int r = pair.first;
                    int c = pair.second;
                    pos = Math.max(pos, upperBound(res.get(r), c));
                }

                if (pos > n) {
                    out.println(-1);
                    continue;
                }

                boolean fail = false;

                for (Pair pair : lt) {
                    int r = pair.first;
                    int c = pair.second;
                    if (res.get(r).get(pos) >= c) {
                        fail = true;
                        break;
                    }
                }

                out.println(fail ? -1 : pos);
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }

    private static int upperBound(List<Integer> list, int value) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
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
