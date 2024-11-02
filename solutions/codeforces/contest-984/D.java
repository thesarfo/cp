import java.io.*;
import java.util.StringTokenizer;

public class D {
    
    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();

            int t = x.nextInt(); 
            for (int i = 0; i < t; i++) {
                int n = x.nextInt(); 
                int m = x.nextInt(); 
                char[][] carpet = new char[n][m];

                for (int j = 0; j < n; j++) {
                    carpet[j] = x.nextLine().toCharArray(); 
                }

                int totalOccurrences = count1543(n, m, carpet);
                out.println(totalOccurrences);
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int count1543(int n, int m, char[][] carpet) {
        String target = "1543";
        int total = 0;

        int sr = 0, er = n - 1; 
        int sc = 0, ec = m - 1; 

        while (sr <= er && sc <= ec) {
            StringBuilder layer = new StringBuilder();

            for (int j = sc; j <= ec; j++) {
                layer.append(carpet[sr][j]);
            }

            for (int i = sr + 1; i <= er; i++) {
                layer.append(carpet[i][ec]);
            }

            if (sr < er) {
                for (int j = ec; j >= sc; j--) {
                    layer.append(carpet[er][j]);
                }
            }

            if (sc < ec) {
                for (int i = er - 1; i > sr; i--) {
                    layer.append(carpet[i][sc]);
                }
            }

            total += countOccurrences(layer.toString(), target);

            sr++;
            er--;
            sc++;
            ec--;
        }

        return total;
    }

    private static int countOccurrences(String layer, String target) {
        String extLayer = layer + layer.substring(0, target.length() - 1);
        int count = 0;

        for (int i = 0; i <= extLayer.length() - target.length(); i++) {
            if (extLayer.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }
        return count;
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
