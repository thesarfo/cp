
You will be given an array of numbers. And a range of those numbers. The goal is to find the only number in that range which is not in the array. For instance, given `[1, 2, 4, 5]`, and `n=5`, the missing number is `3` - because it is the only number from `1 - 5` which is not in the array.

[Leetcode 268](https://leetcode.com/problems/missing-number/description/)

1. **Brute Force Solution**: We iterate through every number from 1 to `n`(the range of numbers), and for each number `i`, we check if it exists in the array using another loop.  Here's how it works

* Outer Loop: We loop over every number from `1` to `n`(inclusive), treating each number as a candidate for the missing number.
* Inner Loop: For each number `i` in the outer loop, we loop through the given array to see if `i` is present.
* Flag Variable: We use a `flag` variable to track whether the number `i` was found in the array. If the number is found, the flag is set to that number, and the loop breaks. If the number is not found, the flag remains `0`
* Return the missing number: If `flag` is `0`(indicting the number was not found in the array), that number is returned as the missing number.

Below is a pseudocode

```pseudocode
for(i = 1; i <= n; i++){
	flag = 0;
	for(j = 0; j < n - 1; j++){
		if(arr[j] == i){
			flag = i;
			break;
		}
	}
	if(flag == 0){
		return i;
	}
}
```

2. **Better Approach**: 

Maybe we can use hashing. We know that the numbers are between 1 and `n`. So we can create a hash array of size `n + 1`(to cover the full array) with all the number in that range. And then we iterate through the original array, on each iteration, we check if that array element exists in the hash array and then we mark it. So at the end, we just have to look for the number that wasn't marked, and that is our missing number.

```pseudocode
hash[n + 1] = {0} // every element in the hash array = 0;
for(i = 0; i < n; i++){
	hash[arr[i]] = i;
}
for(i = 1 -> n){
	if(hash[i] == 0){
		return i;
	}
}
```