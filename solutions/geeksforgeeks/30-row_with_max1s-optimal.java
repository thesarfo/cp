class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxCount = -1, index = -1, n = arr.length, m = arr[0].length;

        for (int i = 0; i < n; i++) {
            int firstOneIndex = lowerBound(arr[i], m, 1);
            int countOnes = m - firstOneIndex; 
            
            if (countOnes > maxCount) {
                maxCount = countOnes;
                index = i;
            }
        }
        return index;
    }

    public int lowerBound(int arr[], int n, int target) {
        int low = 0, high = n - 1, ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) { 
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}