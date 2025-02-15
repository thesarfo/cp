import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();

        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '1') {
                ones.add(i);
            }
        }

        int mid = ones.size() / 2;
        int median = ones.get(mid);

        long totalSwaps = 0;
        for (int i = 0; i < ones.size(); i++) {
            int target = median + (i - mid);
            totalSwaps += Math.abs(ones.get(i) - target);
        }

        System.out.println(totalSwaps);
        scanner.close();
    }
}
