class Solution {
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        
        int first = binarySearch(arr, target, true);
        
        if (first == -1) {
            return 0;
        }
        
        int last = binarySearch(arr, target, false);
        
        return last - first + 1;
    }

    int binarySearch(int[] arr, int target, boolean findFirst) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}e