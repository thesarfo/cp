import java.util.ArrayList;

public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // If there are fewer books than students, allocation is not possible
        if (m > n) {
            return -1;
        }

        // Step 1: Define the search space
        int max = 0, sum = 0;
        for (int a : arr) {
            max = Math.max(max, a);
            sum += a;
        }
        int low = max, high = sum;
        int result = -1;

        // Step 2: Binary search on the answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, n, m, mid)) {
                result = mid; // Update the result to the current feasible value
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result; // The smallest feasible maximum is the answer
    }

    // Helper method to check if the current maxPages is feasible
    private static boolean isFeasible(ArrayList<Integer> arr, int n, int m, int maxPages) {
        int studentCount = 1; // Start with the first student
        int currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                studentCount++; // Allocate books to the next student
                currentSum = pages; // Reset the sum for the new student

                if (studentCount > m) {
                    return false; // More students required than available
                }
            } else {
                currentSum += pages; // Add pages to the current student's total
            }
        }

        return true; // Allocation is possible
    }
}
