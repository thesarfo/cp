import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int selfLoops = 0;
        Set<String> uniqueEdges = new HashSet<>();
        int duplicates = 0;

        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            if (u == v) {
                selfLoops++;
            } else {
                String edge = Math.min(u, v) + " " + Math.max(u, v);
                if (uniqueEdges.contains(edge)) {
                    duplicates++;
                } else {
                    uniqueEdges.add(edge);
                }
            }
        }

        int totalRemoved = selfLoops + duplicates;
        System.out.println(totalRemoved);

        scanner.close();
    }
}
