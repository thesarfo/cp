import java.io.*;
import java.util.StringTokenizer;

public class Template {

    public static void main(String[] args) throws IOException {
        try {
            FastReader x = new FastReader();
            FastWriter out = new FastWriter();
            
            // code here

            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static boolean isprime(long a) {
        if (a == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void reverseArray(int nums[], int low, int high) {
        while (low <= high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public static long power(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long res = power(a, b / 2);
        if (b % 2 == 0) {
            return res * res;
        } else {
            return res * res * a;
        }
    }

    public static long max(long a, long b) {
        return a > b ? a : b;
    }

    public static long min(long a, long b) {
        return a > b ? b : a;
    }

    public static boolean equal(long a, long b) {
        return a == b;
    }

    public static String reverseString(String stu) {
        StringBuilder s = new StringBuilder();
        s.append(stu);
        return s.reverse().toString();
    }

    public static String convert(long number, int base) {
        return Long.toString(number, base);
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
