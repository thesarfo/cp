You are given a 2d array which contains `1`s and `0`s. Your task is to find the row which has the maximum number of ones. Note, that every row in the matrix is **sorted**. In case there are multiple rows with the maximum number of ones, return the row with the smallest index.

[Problem 1](https://www.naukri.com/code360/problems/row-with-maximum-1-s_1112656?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries)  
[Problem 2](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1)  
[Problem 3](https://www.interviewbit.com/problems/row-with-max-1s/)  

1. **Brute Force Solution**:
We can simply go through every row and count the number of `1`s. And just return the row with the max number of ones.

Below is a code implementation

```java
class Solution {
    public int rowWithMax1s(int arr[][]) {
        int max = -1, index = -1;
        
        for(int i = 0; i < arr.length; i++){
            int countOnes = 0;
            for(int j = 0; j < arr[i].length; j++){
                countOnes += arr[i][j];
            }
            if(countOnes > max){
                max = countOnes;
                index = i;
            }
        }
        return index;
    }
}
```

The TC is O(n * m) and the SC of this is O(1). we can optimize this further. Technically we cannot optimize the TC of the matrix traversal, but we can do something about how we compute the `1`s on each row.

Since every row in our matrix is sorted, we can use the *binary search solution*.

2. **Optimal Solution - Binary Search**
We can consider each row as an individual array, and since the row is sorted, we just need to figure out where the first `1` appears in the array. Once we locate the first 1, the count of 1s in the row is `𝑚−index of the first 1`

The first occurence of `1` could be either the 
- Lower bound of `1`
- Upper bound of `0`

**Steps**:
1. For each row:
    * use binary search to find the first occurence of `1`
    * Calculate the count of `1`s: m - index of first 1.

Below is a code implementation

```java
class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxCount = -1, index = -1, n = arr.length, m = arr[0].length;

        for (int i = 0; i < n; i++) {
            int firstOneIndex = lowerBound(arr[i], m, 1);
            int countOnes = m - firstOneIndex; // Number of 1s in the row
            
            if (countOnes > maxCount) {
                maxCount = countOnes;
                index = i;
            }
        }
        return index;
    }

    // Binary search to find the first occurrence of `target` in the row
    public int lowerBound(int arr[], int n, int target) {
        int low = 0, high = n - 1, ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) { // Check if `mid` can be the first occurrence
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; // If no `1` is found, returns `n` (outside valid range)
    }
}
```

The TC of this solution is O(n * log(m)) and the SC is O(1)