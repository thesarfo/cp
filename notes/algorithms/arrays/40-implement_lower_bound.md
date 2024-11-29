The problem is that: Given a sorted array of `n` integers, and an integer `x`, write a program to find the lower bound of `x`. What exactly is the *lower bound*? - It simply refers to the first or smallest index `i`, where `arr[i] >= x`. If the lower bound doesn't exist, we should simply return `n`(the size of the array).

[Practice problem](https://www.naukri.com/code360/problems/lower-bound_8165382) <br>
[Practice Problem](https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1) <br>
[Practice Problem](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

This problem effectively points to the Binary Search Algorithm - where we determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

1. **Brute Force Approach - Linear Search**: With the knowledge that the array is sorted, this approach involves traversing the array starting from the beginning. During this traversal, each element will be compared with the target value, `x`. The index `i`, where the condition `arr[i] >= x` is first satisfied, will be the answer.

Below is a code implementation
```java
public static int lowerBound(int[] arr, int n, int x){
    for(int i = 0; i < n; i++){
        if(arr[i] >= x){
            return i; // lower bound found
        }
    }
    return n;
}
```

The TC of this is O(n) and the SC is O(1).

2. **Optimal Approach - Binary Search**: Since the array is sorted, we can apply Binary Search to find the index.

We will declare the 2 pointers and an `ans` variable initialized to `n`(if we dont find any index, we will return n).


* **Place the 2 pointers, low and high**: Initially, we will place the low pointer to the first index, and high will point to the last index.
* **Calculate the mid**: Now we will calculate the value of mid with the below formula
`mid = (low + high) / 2`
* **Compare arr[mid] with x**: When doing this comparison, we can observe 2 different cases:
    - Case 1 - **If arr[mid] >= x**: This condition means that the index mid may be the answer. So we will update the `ans` variable with mid and search in the left half to see if there is any smaller index that satisfies the same condition. Therefore, we eliminate the right half.
    - Case 2 - **If arr[mid] < x**: This means that mid cannot be our answer, so we need to find a bigger element. SO we will eliminate the left half and search int he right half for the answer.

This process will continue until the low pointer crosses the high pointer.

Below is a code implementation

```java
public static int lowerBound(int[] arr, int n, int x){
    int low = 0, high = n - 1;
    int ans = n;

    while(low <= high){
        int mid = (low + high) / 2;

        if(arr[mid] >= x){
            ans = mid;
            high = mid - 1;
        } else{
            low = mid + 1;
        }
    }
    return ans;
}
```