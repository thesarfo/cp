This algorithm works similarly to merge sort, but instead of using a temporary array - it uses a recursive stack space, so it is slightly better than merge sort.

1. The first step of this algorithm is very simple. Pick a **pivot**. **_A pivot is basically a chosen element of the given array_**. A pivot can be any element in the array. There is no particular rule to pick a pivot. So in an array, a pivot can be any of the following:
 
 * The first element of the array 
 * The last element of the array
 * Median of the array
 * Any random element of the array


Once you pick up a pivot, pick that element, and place it in its correct place in the array(i.e. the place it should be after the array gets sorted)

**NOTE**: In this note, we have chosen the first element as our pivot. You can choose any element of your choice.

Let's take an array `[4, 6, 2, 5, 7, 9, 1, 3]` - assuming you decided to pick a pivot of the **first element** in the array, you will pick `4` and place it in its correct place.(fourth position).

2. **Smaller on the left, larger on the right.** We will shift the smaller elements(i.e. Smaller than the pivot) to the left of the pivot and the larger ones to the right of the pivot. In the example, if the chosen pivot is 4, after performing step 2 the array will look like: `{3, 2, 1, 4, 6, 5, 7, 9}.`

As soon as you pick the pivot and place it in its right position, you can make the assumption that at least one element(pivot) is in its right position. Now you keep repeating the above two steps until the array becomes sorted.

From the explanation, we can see that after completing the steps, pivot 4 is in its correct position with the left and right subarray unsorted. Now **we will apply these two steps on the left subarray and the right subarray recursively**. And we will continue this process until the size of the unsorted part becomes 1(as an array with a single element is always sorted).

Note that, the values to the left of the pivot, and the right of the pivot - can be considered as individual arrays. Therefore you pick the left array. And on the next step, you pick a pivot - (should be the same rule as what you chose for the first pivot), and you compare the other values with it, placing them on the left or right depending on whether they are smaller or larger then this pivot.

After sorting the left array to the pivot, you can apply the same logic to the right side of the array and place it in its correct position until the array becomes sorted.

But if we are considering the values to the left and right of our pivot as separate arrays, does that mean we will be creating new arrays for them. No. We are going to use the concept of **`high`** and **`low`** pointers. 

In order to place the pivot at its right position, you find the first element **greater than the pointer on the left**, and the first element **smaller than the pivot on the right**. And then you swap them. You bring the pointers inwards and repeat the same logic until the pivot goes in is right position. And then you return the **index of the pivot**. This index can be marked as a pointer called **partition index**: this is how you will find the values to the left, and right of the pivot.

Then, you sort the values to the left of the pivot. But this time, instead of going from low to high, you go from low to the **partition index**, and for the right side, you go from **partition index** + 1 to high.


### Approach

Now, let’s understand how we are going to implement the logic of the above steps. In the intuition, we have seen that the given array should be broken down into subarrays. But while implementing, we are not going to break down and create any new arrays. Instead, we will specify the range of the subarrays using two indices or pointers(i.e. **low** pointer and **high** pointer) each time while breaking down the array.

The algorithm steps are the following for the `quickSort()` function:


1. Initially, the **low** points to the first index and the **high** points to the last index(as the range is n i.e. the size of the array). 

2. After that, we will get the index(_where the pivot should be placed after sorting_) while shifting the smaller elements on the left and the larger ones on the right using a partition() function discussed later.  Now, this index can be called the **partition index** as it creates a partition between the left and the right unsorted subarrays.

3. After placing the pivot in the partition index(within the partition() function specified), we need to call the function `quickSort()` for the left and the right subarray recursively. So, **the range of the left subarray will be [low to (partition index - 1)]** and **the range of the right subarray will be [(partition index + 1) to high].** 

4. This is how the recursion will continue until the range becomes 1.

5. This is how the recursion will continue until the range becomes 1

The pseudocode will look like this
```pseudocode
quicksort(arr, low, high){
	if (low < high){
		pIndex = partition(arr, low, high);
		quickSort(arr, low, pIndex - 1);
		quickSort(arr, pIndex + 1, high);
	}
}
```


Now, let’s understand how to implement the partition() function to get the partition index.

1. Inside the function, we will first select the pivot(_i.e._ arr[low] _in our case_).

2. Now, we will again take two-pointers `i` and `j`. The `i` pointer points to low and the j points to high.

3. Now, the pointer `i` will move forward and find the first element that is greater than the pivot. Similarly, the pointer j will move backward and find the first element that is smaller than the pivot.  
    _Here, we need to add some checks like `i` <= high-1 and j >= low+1. Because it might happen that `i` is standing at high and trying to proceed or j is standing at low and trying to exceed._

4. Once we find such elements i.e.` arr[i] > pivot` and `arr[j] < pivot`, and `i < j`, we will swap `arr[i] and arr[j]`.

5. We will continue step 3 and step 4, until `j` becomes smaller than `i`.

6. Finally, we will swap the pivot element(i.e. arr[low]) with arr[j] and will return the index `j` i.e. the partition index.

The pseudocode will look like below
```pseudocode
int partition(arr, low, high){
	pivot = arr[low];
	i = low;
	j = high;

	while(i < j){
		while(arr[i] <= pivot && i <= high - 1){
			i++;
		}

		while(arr[j] > pivot & j >= low + 1){
			j--;
		}

		if(i < j) swap(arr[i], arr[j]);
	}
	swap(arr[low], arr[j]);
	return j;
}
```



## Implementation in C++

```cpp
#include <bits/stdc++.h>

int partition(vector<int> &arr, int low, int high){
    int pivot = arr[low];
    int i = low;
    int j = high;

    while(i < j){
        while(arr[i] <= pivot && i <= high - 1){
            i++;
        }

        while(arr[j] > pivot && j >= low + 1){
            j--;
        }
        if (i < j) swap(arr[i], arr[j]);
    }
    swap(arr[low], arr[j]);
    return j;
}  

void qs(vector<int> &arr, int low, int high){
    if (low < high){
        int pIndex = partition(arr, low, high);
        qs(arr, low, pIndex - 1);
        qs(arr, pIndex + 1, high);
    }
}
  
vector<int> quickSort(vector<int> arr)
{
    // Write your code here.
    qs(arr, 0, arr.size() - 1);
    return arr;
}
```