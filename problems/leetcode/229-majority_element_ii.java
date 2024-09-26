class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int pme = 0, pme2 = 0;
        int count = 0, count2 = 0;
        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (num == pme) {
                count++;
            } else if (num == pme2) {
                count2++;
            } else if (count == 0) {
                pme = num;
                count = 1;
            } else if (count2 == 0) {
                pme2 = num;
                count2 = 1;
            } else {
                count--;
                count2--;
            }
        }

        int vCount = 0, vCount2 = 0;
        for (int num : nums) {
            if (num == pme) {
                vCount++;
            } else if (num == pme2) {
                vCount2++;
            }
        }

        if (vCount > n / 3) {
            result.add(pme);
        }
        if (vCount2 > n / 3) {
            result.add(pme2);
        }

        return result;
    }
}
