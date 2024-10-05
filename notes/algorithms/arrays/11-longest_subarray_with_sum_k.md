You are given an array of positive elements. Your goal is to find the longest **subarray** with a summation of "K", and **return the length** of that subarray.

A subarray simply refers to a "contiguous part of the array". For instance, an array of `[1, 2, 3, 1, 1, 1, 4, 2, 3]`, has a subarray of `[1, 2, 3]` or `[1, 4, 2]`, since they appear contiguously of each other. Now, the question wants us to find the "longest" subarray, that when added, will give us `K`.

For example, if `k=3`, using the above array, `[1, 2]` = 3, `[3]` = 3, and `[1, 1, 1]` = 3. Therefore, the longest subarray that sums up to 3 is `[1, 1, 1]`. And the length of that subarray is `3`


1. **Brute Force Solution**: We can generate all the subarrays, and find everyone's sum that equals to `k`. The longest one is our answer. But how do we generate all the subarrays? We can do that by taking the first element, and appending the rest of the elements to it in incremental order until it reaches the end of the array. Then we go to the second element, do the same thing to the end of the array. In simple terms, iterate over each starting index of the array, and for each starting index, generate all possible subarrays by extending the end index to cover all contiguous parts of the array.

We can use two pointers `i` and `j` for this. Where `i` is the starting index, and `j` is what we keep extending.


```pseudocode
longest_len = 0;
for(int i = 0; i < n; i++){
    for(int j = i; j < n; j++){
        sum = 0;

        for(k = i; k < j; k++){
            sum += arr[j];
        }
        if(sum == k){
            longest_len = max(longest_len, j-i + 1);
        }
    }
}
return longest_len;
```

2. **Better Solution**: We can use hashing to solve this. 