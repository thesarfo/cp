To find the **upper bound** for a given element `x` in a sorted array `arr`, we follow a similar approach to finding the lower bound. However, the **upper bound** is defined as the first index `i` where `(arr[i] > x)`. If no such index exists, the upper bound should return `n` (the size of the array). Here's the extension to your notes:

[Practice Problem](https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1)


### **1. Brute Force Approach - Linear Search**
In the brute force approach, we traverse the array from the beginning and find the first index \( i \) such that \( arr[i] > x \).

#### Code Implementation:
```java
public static int upperBound(int[] arr, int n, int x){
    for(int i = 0; i < n; i++){
        if(arr[i] > x){
            return i; // upper bound found
        }
    }
    return n;
}
```

#### **Time Complexity**: `O(n)`

#### **Space Complexity**: `O(1)`

---

### **2. Optimal Approach - Binary Search**
Using binary search, we can find the upper bound more efficiently. Here's how:

#### Steps:
1. **Declare two pointers**: Initialize `low` to 0 and `high` to `n - 1`. Also, initialize an `ans` variable to `n` (in case no upper bound is found).
2. **Calculate the mid**: Use the formula `mid = low + high / 2`.
3. **Compare `arr[mid]` with  `x`**:
    - **Case 1**: If `arr[mid] > x`, then `mid` is a potential answer. Update `ans = mid` and search the left half `(high = mid - 1)`.
    - **Case 2**: If `arr[mid] <= x`, the current `mid` cannot be the answer, so search the right half `(low = mid + 1)`.
4. **Repeat** until `low` crosses `high`.

#### Code Implementation:
```java
public static int upperBound(int[] arr, int n, int x){
    int low = 0, high = n - 1;
    int ans = n;

    while(low <= high){
        int mid = (low + high) / 2;

        if(arr[mid] > x){
            ans = mid;
            high = mid - 1;
        } else{
            low = mid + 1;
        }
    }
    return ans;
}
```

#### **Time Complexity**: `O(log n)`

#### **Space Complexity**: `O(1)`

---

**Key Differences Between Lower Bound and Upper Bound**:

| **Criterion**         | **Lower Bound**                     | **Upper Bound**                     |
|------------------------|-------------------------------------|-------------------------------------|
| **Condition**          | `arr[i] >= x`                      | `arr[i] > x`                        |
| **Potential Answer**   | Search left if `arr[mid] >= x`      | Search left if `arr[mid] > x`       |
| **Final Answer**       | Smallest index `i` with `arr[i] >= x` | Smallest index `i` with `arr[i] > x` |