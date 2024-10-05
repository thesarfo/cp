
What this algorithm does is that it pushes the maximum value to the last through adjacent swaps.

For instance, given an array of `13, 46, 24, 52, 20, 9`, the bubble sort algorithm will try to sort it as follows.

It will first check if the first two elements are sorted. `13` is less than `24`, so they are sorted - therefore, nothing happens here. The second time, it check `46` and `24` to see if they are sorted. Since `46` is greater than `24`, it means that they are not sorted - therefore the algorithm will swap the positions of `46` and `24`. Then it will check and compare the next two elements, making swaps where necessary. This happens until the checks reach the last element of the array.

On the first iteration of the loop, the maximum number will be at the last. (i.e. `52` will be swapped to the last). So on the second iteration, the loop goes all the way to the last but one element. This is because the maximum value(`52`) has already been swapped to the very end. Therefore, there is no need for the second loop to go all the way to `52`.

On the second iteration of the loop, the second maximum number (`46`), will be swapped to the last but one element(right before `52`). Therefore, there is no need for the third loop to go all the way to `46`. This happens until the entire array is sorted.

For the above array, the iterations and swaps happen as below

1st iteration  -   loop from 0 to `n-1`
2nd iteration -   loop from 0 - `n-2`
3rd iteration  -   loop from 0 - `n-3`
4th iteration  -   loop from 0 - `n-4`
5th iteration  -   loop from 0 - `n-5`

The pseudocode for bubble sort would look like this

```pseudocode
for(int i = n - 1; i >= i; i--){
	for (j = 0; j <= i-1; j++){
		if (a[j] > a[j + 1] ){
			swap
		}
	}
}
```

This is how an implementation would look like in C++
```cpp
void bubble_sort(int arr[], int n){
	for (int i=n-1; i>=0; i--){
		for(int j=0; j<=i-1; j++){
			if (arr[j] > arr[j+1]){
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
	}
}
```

The time complexity of the above algorithm is O(n * n). But it can be optimized further. Assuming you are already given a sorted array. `3, 5, 7, 9, 10`. There is no point in checking everything for possible swaps. Therefore, we can optimize this algorithm further by checking if the input array is already sorted.

If the first iteration happens, and no swap happened, we can conclude that indeed the array is sorted, therefore we don't need to begin another loop. Here's how we can implement that in code.

```cpp
void bubble_sort(int arr[], int n){
	int didSwap = 0; // a variable to check if swapping happened
	for (int i=n-1; i>=0; i--){
		for(int j=0; j<=i-1; j++){
			if (arr[j] > arr[j+1]){
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
				didSwap = 1; // set the variable to 1 if some swapping happened
			}
		}
		if(didSwap == 0){ // no swap happened
			break; // exit the loop(i.e sorted array)
		}
	}
}
```