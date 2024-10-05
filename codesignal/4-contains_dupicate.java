int solution(int[] a) {

    HashSet<Integer> seen = new HashSet<>();

    for (int num : a) {
        if (seen.contains(num)) {
            return num;
        }
        seen.add(num);
    }
    return -1;
}
