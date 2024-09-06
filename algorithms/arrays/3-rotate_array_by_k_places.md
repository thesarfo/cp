### Left Rotate Array By K Places

What exactly is array rotation. A left rotation of an array means shifting the elements to the left, with the element at the start of the array moving to the end. For example, given the array `[1, 2, 3, 4, 5]`, a left rotation by one position would result in `[2, 3, 4, 5, 1]`.


#### One Place Rotation
So `[2, 3, 4, 5, 1]` - shows that the first element has been pushed to the last place in the array, and as such all the other elements have been shifted.

This is a pretty simple solution, and we need to solve the problem in the given array itself. Of course, we can create a whole new array and store them in it, but it's not necessary.

How do we approach this problem. First of all, we know that a one place rotation simply moves the first element to the last place. Therefore, we can create a temporary variable to hold that element - `arr[0]`. And then we simply shift the rest of the elements one index to the left, or to the position before. Therefore, when we get to `arr[i]`, we shift it to `arr[i-1]`. Finally, after we're done. We will take the temporary variable(which contains our first element) and then put it at the last position.

A simple pseudo-code would look like this
```pseudocode
temp = arr[0]

for(i = 1, i < n; i++){
    arr[i-1] = arr[i];
}
arr[n-1] = temp; // push the first element to the last
```

### K Place Rotation

Now that you've been able to rotate an array by one place, the next thing is to rotate the array by the given number of places(k). This means we need to design an algorithm that can rotate an array by any number of places

Just like left rotating an array by one place moved the first element to the end, rotating by two places would move the first two elements to the end, rotating by three places would move the first three elements to the end, and so on so forth.

If `k=3` an array of `[1, 2, 3, 4, 5]`, would be rotated to `[4, 5, 1, 2, 3]`. However, note that, rotating an array by its size just gives you the original array. Taking the above example, if `k=5` the array stays the same.

But, does that mean you cannot rotate the array if `k > n`? Actually you can. Taking the above example. If `k=6`, you can simply divide it into `5` + `1` -> with `5` being the size of the array. In 5 rotations it comes back to the original array, then you just rotate it one more time. If `k=13`, you can divide it into `5` + `5` + `3` which simply means you rotate the original array b `3` times.

So can we say that anytime `k` is a multiple of `n` or `5` in this scenario, it always brings us back to the original array? yes we can. This means that the value of `k` doesn't matter. Because we can always rotate the array by `k = k % n` times regardless.

1. **Brute Force Approach**: In the above solution where we had to rotate by just one place, we stored the first element in a temporary variable and shifted it to the end of the array. We can do the same if `k=3` -> we will just create a temporary array to hold the first 3 elements of the original array, and then place them at the last position. No matter what `k` is, we can store them in a temporary variable.

How then do we do the shifting, if `k = 3` we start shifting from the 3rd index or the `kth` index and then we shift them `k` times. Since `k = 3` we will shift `arr[i] to arr[i - d]` that means we shift each element 3 times.

After we have done the shifting, we take the temporary array, and place them to the last positions - one by one. Now note that, if we shift the elements by `k` places, the free spaces we can place our temporary array will be `n - k`. So we place the temporary array at the `n-kth` index

If `k=3` an array of [1, 2, 3, 4, 5] will first be shifted as [4, 5]. Since [1, 2, 3] are in the temporary array, we know that we can place the temporary array at the`5 - 3th` index. Which is `2`


A pseudocode of this brute force would look like this
```pseudocode
temp[] = {1, 2, 3} // store k in a temporary array

// shift the elements by k places
for(i = k; i < n; i++){
    a[i - k] = a[i];
}

// place the temp array at the n-kth index
for(i = n - k; i < n; i++){
    a[i] = temp[i - (n - k)];
}
```

A java implementation could look like this
```java
public class Solution {
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> temp = new ArrayList<>(arr.subList(0, k));

        for(int i = k; i < arr.size(); i++){
            arr.set(i - k, arr.get(i));
        }

        int j = 0;
        for(int i = arr.size()-k; i < arr.size(); i++){
            arr.set(i, temp.get(j));
            j++;
        }

        return arr;
    }
}
```

Here's another implementation in c++
```cpp
vector<int> rotateArray(vector<int>arr, int k) {
    // Write your code here.
    k = k % arr.size(); // handle cases where k > arr size

    int temp[k];

    for(int i = 0; i < k; i++){
        temp[i] = arr[i];
    }

    for(int i = k; i < arr.size(); i++){
        arr[i - k] = arr[i];
    }

    for(int i = arr.size() - k; i < arr.size(); i++){
        arr[i] = temp[i - (arr.size() - k)];
    }
    return arr;
}
```