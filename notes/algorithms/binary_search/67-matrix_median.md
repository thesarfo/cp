You have been given a row-wise sorted matrix. This matrix has an odd number of rows, and also an odd number of columns. And your task is to find and return the **median** of this given matrix.

A *median* refers to the **middle value** of a sorted list of integers. For a matrix with m rows and n columns, the median is the element at the position `(m * n) // 2` if all elements were sorted.

[Problem Link](https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix)


**1. Brute Force Solution**:

We can just iterate through the 2d matrix, and add each element to a 1d array. After that, we will sort the 1d array, and just return the middle value. 

Below is a code implementation
```java
public static int findMedian(int[][] matrix) {
        // Step 1: Flatten the matrix into a 1D array
        int[] flattened = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                flattened[index++] = matrix[i][j];
            }
        }

        // Step 2: Sort the 1D array
        Arrays.sort(flattened);

        // Step 3: Find the median (middle element)
        int median = flattened[flattened.length / 2];

        return median;
    }
```

The TC is `O(n * m)` for matrix traversal and the sorting is `O(n * m * log(n * m))`. Therefore the total TC is `O(n * m + n * m * log(n * m))`.

We can optimize this further


**2. Optimal Solution - Binary Search**:

The matrix traversal for the brute force is `n * m`, but if we wanted to optimize this, perhaps we could find an approach that would allow us to skip some elements during traversal, thereby reducing the `n * m` TC.

Also, the matrix has been sorted row-wise. So we can use the **binary search** approach for this. All we need is our *search space* which will be between the smallest and largest elements in our matrix.`(min(matrix), max(matrix))`

Now, we know that the rows and columns of the matrix are all odd. If we considered a sorted 1d array, we know that the median element will be the element in the middle which has even number of elements to the left of it, and an even number of elements to the right of it. This element will be at the `m * n / 2` position if we were considering a matrix.

Therefore, if a given element is the median, the number of elements smaller or equal to this element will surely be greater than `m * n / 2` (integer division).

Therefore, we need to check how many numbers are smaller or equal to an element `mid`. We could traverse the whole matrix and count the numbers. But its not a good approach. Given that the matrix is row-wise sorted, we can apply the concept of [upper bound](../binary_search/41-implement_upper_bound.md). The **upper bound** returns the first element greater than a given target. 

So,

- For every particular row, we will find the upper bound of the current element `mid`. The index returned will be the number of elements smaller or equal to elements in that row.
- We will do it for each row and add them to get the total number for the whole matrix.
- Mathematically, `smaller_equal_in_row = upperBound(matrix[row], mid)`

Below are the steps

1. Calculate `min(matrix)` and `max(matrix)`: Since the given matrix is row-wise sorted, the minimum element will be the minimum element in the first column and the maximum will be the maximum in the last column.

2. **Place the 2 pointers low and high**: Initially, we will place the pointers. The pointer low will point to min(matrix) and the high will point to max(matrix).

3. **Calculate the ‘mid’**: Now, inside a loop, we will calculate the value of `mid` using the following formula: `mid = (low+high) // 2` ( ‘//’ refers to integer division).

4. **Use the `calculateSmallEqual()` function to get the number of elements <= mid:** Inside the function, we will use the above-mentioned upper bound formula for each row and calculate the total number of elements <= `mid`. Then we will return the total number from the function `calculateSmallEqual()`.

5. **If `smallEqual <= (M*N) // 2:`** We can conclude that our median must be a bigger number. So, we will eliminate the left i.e. the smaller half (`low = mid+1`)

6. **If `smallEqual > (M*N) // 2`**: We can conclude that the element mid might be the median. But we have to reach the smallest number to find the actual median. So, in this case, we will remove the right half( i.e. `high = mid-1`).

The steps from 3-6 will be inside a loop and the loop will continue until low crosses high