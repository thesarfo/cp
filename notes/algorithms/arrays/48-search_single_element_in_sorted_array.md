You have been given an array of `n` integers. Every number in the array appears twice except one. Your goal is to find
the single number in the array.

1. **Brute Force Approach**: A crucial observation to note is that if an element appears twice in a sequence, either the
preceding or subsequent element will also be the same. But only for the single element, this condition will not be satisfied. So we can check this condition with the following

    - If `arr[i] != arr[i-1] && arr[i] != arr[i + 1]`: If this condition is true for any alement, we can conclude this is the single element.

    There are some **edge cases** we need to consider with this approach

    - If `n == 1`: This means the array size is 1. In this case, we return that element only.
    - If `i == 0`: This means its the first element in the array. The only condition we'll need to check is `arr[i] != arr[i + 1]`.
    - If `i == n - 1`: This means its the last elemetn in the array. The only condition we'll need to check is `arr[i] != arr[i-1]`

    So, we will traverse the array and check for the above conditions.

    - At first, we will check if the array contains only 1 element. If it is, we will simply return that element.
    - We will start traversing the array. Then for every element, we will check the following.
    - If `i == 0`: If we are at the first index, we will check if the next element is equal.
        - If `arr[i] != arr[i+1]`: This means `arr[i]` is the single element and so we will return `arr[i]`.
    - If `i == n-1`: If we are at the last index, we will check if the previous element is equal.
        - If `arr[i] != arr[i-1]`: This means `arr[i]` is the single element and so we will return `arr[i]`.
    - For the elements other than the first and last, we will check:
        - If `arr[i] != arr[i-1] and arr[i] != arr[i+1]`: If this condition is true for any element, arr[i], we can conclude this is the single element. And we should return arr[i].

Below is a code implementation

```java
public static int solution(int[] arr){
    if (arr.length == 1) return arr[0];
    
    for(int i = 0; i < arr.length; i++){
        if(i == 0){
            if(arr[i] != arr[i + 1]) return arr[i];
        } else if(i == arr.length - 1){
            if(arr[i] != arr[i - 1]){
                return arr[i];
            }
        } else{
            if(arr[i] == arr[i-1] && arr[i] == arr[i + 1]){
                return arr[i];
            }
        }
    }
    return -1;
}
```

**Another Brute Force Approach (Using XOR)**: There are 2 important properties of XOR.

1. a ^ a = 0, XOR of two same number always results in 0.
2. a ^ 0 = a, XOR of a number with 0 always results in that number.

Now, if we XOR all the array elements, all the duplicates will result in 0 and we will be left with a single element.

So, we will do the following:
- Declare an `ans` variable initialized to `0`
- Traverse the array and XOR each element with the variable `ans`
- After a complete traversal, the `ans` variable will store the single element and we will return it.

Below is a code implementation

```java
public static int solution(int[] arr){
    int ans = 0;
    
    for(int i = 0; i < arr.length; i++){
        ans = ans ^ arr[i];
    }
    return ans;
}
```


2. **Optimal Approach - Using Binary Search**:




**Binary Search Overview**
The primary goal of Binary Search is to reduce the search space by half with each iteration. In this problem, Binary Search determines which half to eliminate based on specific conditions and checks if the middle element (`arr[mid]`) is the single element.

**Key Steps in Binary Search for This Problem**
1. Identify whether `arr[mid]` is the single element.
2. Determine which half to eliminate based on the index sequence of duplicate numbers.



**1. How to Check if `arr[mid]` is the Single Element**
If an element appears twice, it will have an adjacent duplicate. The single element won't satisfy this condition:
- **Condition**: `arr[mid] != arr[mid-1]` and `arr[mid] != arr[mid+1]`
- If this is true, `arr[mid]` is the single element.

#### **Edge Cases**
The above condition may fail in these cases:
1. **Array size is 1**: The single element is the only element.
2. **`mid` is the first index (`0`)**: There is no `arr[mid-1]`.
3. **`mid` is the last index (`n-1`)**: There is no `arr[mid+1]`.

#### **Preliminary Checks for Edge Cases**
1. If `n == 1`, return the only element.
2. If `arr[0] != arr[1]`, return `arr[0]` (first element is single).
3. If `arr[n-1] != arr[n-2]`, return `arr[n-1]` (last element is single).


**2. Identifying Left and Right Halves**

**Observation: Index Patterns of Duplicate Pairs**
1. **Left Half** (before the single element):
   - Duplicates follow an `(even, odd)` pattern:
     - `arr[i] == arr[i+1]` when `i` is even.
     - `arr[i] == arr[i-1]` when `i` is odd.
2. **Right Half** (after the single element):
   - Duplicates follow an `(odd, even)` pattern:
     - `arr[i] == arr[i-1]` when `i` is even.
     - `arr[i] == arr[i+1]` when `i` is odd.

**Deciding the Current Half**
Use the following conditions:
- **Left Half**: 
  - `(i % 2 == 0 and arr[i] == arr[i+1])`
  - `(i % 2 == 1 and arr[i] == arr[i-1])`
- **Right Half**:
  - `(i % 2 == 0 and arr[i] == arr[i-1])`
  - `(i % 2 == 1 and arr[i] == arr[i+1])`

Here, the current index `i` refers to the middle index (`mid`).


**3. Eliminating Halves**
- If `mid` is in the **left half**, set `low = mid + 1` to search the right half.
- If `mid` is in the **right half**, set `high = mid - 1` to search the left half.


## **Algorithm**

1. **Handle Edge Cases**:
   - If `n == 1`, return `arr[0]`.
   - If `arr[0] != arr[1]`, return `arr[0]`.
   - If `arr[n-1] != arr[n-2]`, return `arr[n-1]`.

2. **Initialize Pointers**:
   - `low = 1`
   - `high = n - 2` (exclude already checked first and last elements).

3. **Binary Search Loop**:
   - Compute `mid = (low + high) // 2`.
   - Check if `arr[mid]` is the single element:
     - If `arr[mid] != arr[mid-1]` and `arr[mid] != arr[mid+1]`, return `arr[mid]`.
   - Determine the half:
     - If `(mid % 2 == 0 and arr[mid] == arr[mid+1])` or `(mid % 2 == 1 and arr[mid] == arr[mid-1])`, eliminate the left half: `low = mid + 1`.
     - Otherwise, eliminate the right half: `high = mid - 1`.

4. **Continue Loop**:
   - The loop ends when the single element is found.


Below is a code implementation

```java
   public static int singleNonDuplicate(int[] arr) {
        int n = arr.length; // Size of the array.

        // Edge cases:
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // We are in the left half:
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right half:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement (in theory, we should never reach here):
        return -1;
}
```