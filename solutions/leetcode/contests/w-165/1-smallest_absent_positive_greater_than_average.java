class Solution {
    public int smallestAbsent(int[] nums) {
        double sum = 0;
        for(int n : nums) sum+= n;
        double avg = sum / nums.length;

        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            if(n > 0) s.add(n);
        }
        int res = Math.max(1, (int)avg + 1);
        while(s.contains(res)) res++;
        return res;
    }
}