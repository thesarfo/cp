You are given an array of both positive and negative integers. Your task is to find the maximum product subarray. This simply refers to the subarray that has the maximum product.

For instance, given an array of `[1, 2, 3, 4, 5, 0]`, you will return `120` because we can see that `1x2x3x4x5` gives us the maximum product value.

1. **Brute Force Solution**: We can simply find all the possible subarrays in the input array, find the product of each subarray, and then return the maximum out of all of them. First, we run a loop on the array to choose the starting point for each subarray, and then we run a nested loop to get the end point for each subarray. Then we multiply elements present in the chosen range.

Below is a code example

```java
	static int maxProductSubArray(int arr[]) {
	    int result = Integer.MIN_VALUE;
	    for(int i=0;i<arr.length-1;i++) 
	        for(int j=i+1;j<arr.length;j++) {
	            int prod = 1;
	            for(int k=i;k<=j;k++) 
	                prod *= arr[k];
	            result = Math.max(result,prod);
	        }
	   return result;     
	}
```

The TC of this is nearly O(n3) and the SC is O(1) because we do not use any extra space.

2. **Better Solution**: We can optimize the brute force by making 3 nested iterations to 2 nested iterations. SO first we run a loop to find the start of the subarrays, then we run another nested loop - within which we multiply each element and store the maximum value of all the subarrays.

```java
	static int maxProductSubArray(int arr[]) {
	    int result = arr[0];
	    for(int i=0;i<arr.length-1;i++) {
	        int p = arr[i];
	        for(int j=i+1;j<arr.length;j++) {
	            result = Math.max(result,p);
	            p *= arr[j];
	        }
	        result = Math.max(result,p);
	    }
	   return result;     
	}
```

The TC for this is O(n2) while the SC is O(1) because we don't use any extra space.

3. **First Optimal Solution - Observation**: We can make some observations

- **If the given array only contains positive numbers**: If this is the case, we can confidently say that the maximum product subarray will be the entire array itself.
- **If the given also array contains an even number of negative numbers**: As we know, an even number of negative numbers always results in a positive number. So, also, in this case, the answer will be the entire array itself.
- **If the given array also contains an odd number of negative numbers**: Now, an odd number of negative numbers when multiplied results in a negative number. Removal of 1 negative number out of the odd number of negative numbers will leave us with an even number of negatives. Hence the idea is to remove 1 negative number from the reesult. Now we need to deide which 1 negative number to remove such that the remaining subarray yields the maximum product. When we pick a negative number to ignore, the result we're loooking for will either be in the **prefix** or **suffix** of the negative number. Same logic, if the array contains a `0`, it doesnt make sense to multiply with it since it will yield `0` so we have to also ignore the `0`s in the array, and choose an answer from the rest of the elements.

On each iteration, there's the possibility of a `0`, so if we get to a zero, we reset the `prefix` to 1 or reset the `suffix` to 1.

Below is a code implementation

```java
public static int maxProductSubArray(int[] arr) {
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1]; // calculate from the back
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
```