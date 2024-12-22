class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        if (n < 3)
            return false;

        while ((left + 1) < n - 1 && arr[left] < arr[left + 1]) {
            left++;
        }

        while ((right - 1) > 0 && arr[right] < arr[right - 1]) {
            right--;
        }

        return left == right;
    }
}
