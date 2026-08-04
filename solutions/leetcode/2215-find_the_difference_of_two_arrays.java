class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();

        Set<Integer> set2 = Arrays.stream(nums2)
                                    .boxed()
                                    .collect(Collectors.toSet());

        Set<Integer> set1 = Arrays.stream(nums1)
                                    .boxed()
                                    .collect(Collectors.toSet());

        for(int num: set1){
            if(!set2.contains(num)){
                row1.add(num);
            }
        }
        matrix.add(row1);

        for(int num: set2){
             if(!set1.contains(num)){
                row2.add(num);
            }
        }
        matrix.add(row2);

        return matrix;

    }
}
