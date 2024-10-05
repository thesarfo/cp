
Merge sort is a **divide and merge** algorithm. This means it breaks down a problem into smaller parts, solves those parts, and then combines the solutions to solve the original problem. Merge Sort is a way to sort a list or array of items(like numbers) in order.

#### How does it work?

1. **Divide**:
	* Split the list into two halves. If the list has one item, it's already sorted, so you don't need to split it further.
	* Keep splitting the list until each one has only one item
2. **Conquer**(Sort and Merge):
	* Start merging the list back together, but in a way that sorts them as you go.
	* Compare the items from each half, and put them together in order. Do this for all the small lists until you combine and have one big sorted list
3. **Combine**
	* The small sorted list gets combined step by step until you end up with one completely sorted list.

##### Example
Imagine you have this list of numbers to sort: `[38, 27, 43, 3, 9, 82, 10]`.

Let's sort them using Merge Sort.

1. **Divide**
	* Split the list into two halves: `[38, 27, 43]` and `[3, 9, 82, 10]` -> it doesn't matter if you split them (small, large) or (large, small).
	* Keep splitting:
	     * `[38, 27, 43]` becomes `[38]` and `[27, 43]`
	     * `[27, 43]` becomes `[27]` and `[43]`
	     * `[3, 9, 82, 10]` becomes `[3, 9]` and `[82, 10]`
	     * `[3, 9]` becomes `[3]` and `[9]`
	     * `[82, 10]` becomes `[82]` and `[10]
	     * 
2. **Conquer**(Sort and Merge): 
    * Merge `[27]` and `[43]` to get `[27, 43]`
	- Merge `[38]` and `[27, 43]` to get `[27, 38, 43]`
	- Merge `[3]` and `[9]` to get `[3, 9]`
	- Merge `[82]` and `[10]` to get `[10, 82]`
	- Merge `[3, 9]` and `[10, 82]` to get `[3, 9, 10, 82]`

3. **Combine**:
     * - Finally, merge `[27, 38, 43]` and `[3, 9, 10, 82]`:
	- Start comparing and merging:
	    - `3` is smaller than `27`, so start with `3`
	    - `9` is smaller than `27`, so next is `9`
	    - `10` is smaller than `27`, so next is `10`
	    - `27` is next, then `38`, then `43`, and finally `82`
	- The final sorted list is **`[3, 9, 10, 27, 38, 43, 82]`**


Now let's understand this. If we are going to break down the array into two smaller arrays, and then break the smaller arrays into two smaller arrays - and so on...it wouldn't really make sense.

This is where we try to play around with **indexes**. In order to write some pseudocode, let's take an array of size 5. `[3, 2, 4, 1, 3]`.  A simple loop will go until index `4`.

We can refer to our first array index as **low** and our last array index as **high**, referring to the starting and ending points of our hypothetical array.


```pseudocode
merge_sort(arr, low, high){
	if(low >= high){
		return;
	}

	middle = (low + high) / 2;

	merge_sort(arr, low, mid);
	merge_sort(arr, mid+1, high);

	merge(arr, low, mid, high); // this is where we compare and merge
}
```

Instead of making two new arrays, we use the low and high indexes to divide the arrays and sort them. What is happening above is a recursive approach. So we keep dividing the arrays, but until what point do we stop the divisions, we need a **base case** for that. 

We can stop dividing the array if it contains only one element. In other words, if `low` and `high` point to the same value. Therefore, that is our base case.

The above pseudocode doesn't actually demonstrate the logic in merging the smaller arrays. But below is how we do that.

```pseudocode
merge(arr, low, mid, high){
	temp = [];
	left = low;
	right = mid + 1;

	while(left <= mid && right <= high){ //while there are still some elements
		if(arr[left] <= arr[right]){
			temp.add(arr[left])	 // add the smaller one to the new array
			left++; // move the left pointer to the right
		} else{
			temp.add(arr[right]); // add the smaller one to the new array
			right++; // move the right pointer to the left
		}
	}

	// if after merging, and there are still some elements left
	while(left <= mid){
		temp.add(arr[left]);
		left++;
	}

	while(right <= high){
		temp.add(arr[right]);
	}

	// move the sorted array from the temporary array into the original array
	for(i = low to high){
		arr[i] = temp[i-low];
	}
}
```


## In Code

A simple solution could look like this in c++

```cpp
void merge(vector<int> &arr, int low, int mid, int high){
	vector<int> temp;

	int left = low;
	int right = mid+1;

	while (left <= mid && right <= high){
		if(arr[left] <= arr[right]){
			temp.push_back(arr[left]);
			left++;
		} else{
			temp.push_back(arr[right]);
			right++;
		}
	}

	while(left <= mid){
		temp.push_back(arr[left]);
		left++;
	}

	while(right <= high){
		temp.push_back(arr[right]);
		right++;
	}

	for(int i = low; i<=high; i++){
		arr[i] = temp[i - low];
	}
}

void ms(vector<int> &arr, int low, int high){
	if(low == high) return;

	int mid = (low + high) / 2;
	ms(arr, low, mid);
	ms(arr, mid+1, high);

	merge(arr, low, mid, high);
}

void mergeSort(vector<int> &arr, int n){

	ms(arr, 0, n-1);
}
```


Another solution could go like this

```cpp
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSortHelper(nums, 0, nums.size() - 1);
        return nums;
    }

    void mergeSortHelper(vector<int> &nums, int low, int high){

        if(low < high){
            int mid = (low + high) / 2;
            mergeSortHelper(nums, low, mid);
            mergeSortHelper(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    void merge(vector<int> &nums, int l, int m, int r){
        vector<int> left(nums.begin() + l, nums.begin() + m + 1);
        vector<int> right(nums.begin() + m + 1, nums.begin() + r + 1);

        int i = 0, j = 0, k = l;

        while (i < left.size() && j < right.size()) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while (i < left.size()) {
            nums[k++] = left[i++];
        }

        while (j < right.size()) {
            nums[k++] = right[j++];
        }
    }

};
```

