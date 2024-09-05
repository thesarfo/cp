This algorithm simply takes an element, and places it in its correct position. By placing such element in its correct position, the rest of the elements are right shifted by 1.

This algorithm works similarly to the way you might sort playing cards in your hand. You start with one card, and then pick up one card at a time, inserting it into the correct position among the previously sorted cards. The array is divided into a "sorted" section and an "unsorted" section. With each iteration, the algorithm takes an element from the unsorted section and places it in the correct position in the sorted section.

For instance, given an array of `9, 14, 15, 12, 6, 8, 13` - This is how the *insertion sort* algorithm will work.

1. First checks if only `9` is at its right position. 
2. Second, it checks between `9, 14` to see if `14` is at its right position
3. Third, it checks between `9, 14, 15` to see if `15` is at its right position
4. Fourth, it checks between `9, 14, 15, 12` to see if `12` is at its right position - if its not, it places `12` right after `9` - but it doesn't do it instantly. 
* First it will swap the positions of `12` and `15`. 
* Then it will swap the positions of `12` and `14

So it basically swaps swaps swaps until it cannot be swapped anymore 

The pseudocode for this algorithm would be as follows
```pseudocode
for(int i = 0; i < n - 1; i++){
	j = i;
	while(j > 0 && a[j-1] > a [j]) {
		swap(a[j-1], a[j])
		j--;
	}
}
```

Here's how it would look like in C++
```cpp
void insertion_sort(int arr[], int n){
	for (int i = 1; i <= n-1; i++){
		int j = i;
		while(j > 0 && arr[j-1] > arr[j]){
			int temp = arr[j - 1];
			arr[j-1] = arr[j];
			arr[j] = temp;

			j--;
		}
	}
}
```