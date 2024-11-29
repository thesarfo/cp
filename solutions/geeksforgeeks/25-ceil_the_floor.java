class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr); 

        int floor = -1;
        int ceil = -1;

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                floor = arr[mid]; 
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ceil = arr[mid]; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return new int[]{floor, ceil};
    }
}
