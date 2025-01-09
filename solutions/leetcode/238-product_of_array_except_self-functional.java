class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        apply(nums, (i) -> {
            if (i == 0) answer[i] = 1;
            else answer[i] = answer[i - 1] * nums[i - 1];
        });

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    private void apply(int[] nums, Consumer<Integer> consumer) {
        for (int i = 0; i < nums.length; i++) {
            consumer.accept(i);
        }
    }
}