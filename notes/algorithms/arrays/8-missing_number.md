
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

3. **Optimal Approach**: We can use the **sum of first `n` natural numbers** to solve this problem. The formula for summing up the first `n` natural numbers is `n * (n + 1) / 2`. So what we do is that we sum up all the natural numbers in the range of the array. Then, we create another sum, which sums up all the elements in the actual array. 

Then we compare both. The difference between the two summations is our missing number.

A pseudocode would look like below
```pseudocode
sum = n * (n + 1) / 2;
s2 = 0

for (i = 0 -> n){
	s2 += arr[i];
}
return sum - s2
```


**Another Optimal Approach is to Use the XOR operator**

One concept of **XOR** is that if you XOR the same number, the result of that is always `0`. And if you XOR `0` with any number, the result if the number itself

First we will find the XOR of the first `n` natural numbers. Then, we find the XOR of the elements in the array. Finally, we find the XOR of both. The result will be our missing number. 

This is because `xor1 = 1 ^ 2 ^ 3 ^ 4 ^ 5` and `xor2 = 1 ^ 2 ^ 3 ^ 5`. Now, when we perform a `xor1 ^ xor2`, it computes as follows...

* 1 ^ 1 
* 2 ^ 2
* 3 // because there is no 3 in our array, we dont know what to xor it with, so it stays alone
* 4 ^ 4
* 5 ^ 5

Now, we know the XOR of a number and itself is `0`. So all the operations above are `0` except for `3`. So `3` is our missing number.

Below is a pseudocode
```pseudocode
xor1 = 0
for(i = 1 -> n){
	xor1 = xor1 ^ i;
}

xor2 = 0;
for(i = 0 -> n - 1){
	xor2 = xor2 ^ arr[i];
}

return xor1 ^ xor2

```

However, instead of calculating the XOR of the first `n` numbers and the XOR of the elements in the array separately, we can do it in one single pass, by XOR-ing both the index and the array element at the same time

Below is a pseudocode
```pseudocode
int xor1 = 0, xor2 = 0;

int n = arr.size();
for(int i = 0; i < n; i++){
	xor2 = xor2 ^ a[i];
	xor1 = xor1 ^ (i + 1);
}
return xor1 ^ xor2
```