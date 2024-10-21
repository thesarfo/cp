import java.util.ArrayList;

public class Solution {

    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low;      // Starting index of left half of arr
        int right = mid + 1; // Starting index of right half of arr

        // Storing elements in the temporary array in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Add remaining elements from the left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements from the right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer all elements from the temp array back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Function to count the number of valid pairs
    private static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    // Merge sort function with counting pairs step
    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;  // Base case for recursion
        int mid = (low + high) / 2;

        // Recursively sort left and right halves and accumulate counts
        int count = mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        // Count the pairs and then merge the sorted subarrays
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }

    // Public function to initiate the sorting and counting process
    public static int team(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }
}
