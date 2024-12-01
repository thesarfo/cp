class Solution {
    public int getLargestOutlier(int[] nums) {
        int ist = 0;
        for (int num : nums) {
            ist += num; 
        }

        Map<Integer, Integer> hmp = new HashMap<>();
        for (int num : nums) {
            hmp.put(num, hmp.getOrDefault(num, 0) + 1);
        }

        int oul = Integer.MIN_VALUE;  

        for (int num : nums) {
            int rms = ist - num;
            if (rms % 2 == 0) {
                int sfh = rms / 2;
                hmp.put(num, hmp.get(num) - 1);

                if (hmp.getOrDefault(sfh, 0) > 0) {
                    oul = Math.max(oul, num);
                }
                hmp.put(num, hmp.get(num) + 1);
            }
        }

        return oul;  
    }
}