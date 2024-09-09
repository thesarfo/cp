For instance, given an array1 = `[1, 1, 2, 3, 4, 5]` and an array2 = `[2, 3, 4, 4, 5, 6]`, return a union of the two. A union simply means the result of the combination of both arrays. However, the union shouldn't contain duplicates - its elements should be unique. Therefore, the union for the above two arrays will be `[1, 2, 3, 4, 5, 6]`.

---
1. **Brute Force Approach**: Whenever we say the word "unique", we think of a map or a set. We can take an empty set, and add the elements of arr1 into the set. Then we add the elements of arr2 into the set. Since sets only contain unique elements, it will not store any element of arr2 that it already contains. After doing that, we can create a new array of the set's size, and add the elements of the set into the array.

```pseudocode
Function findUnion(arr1[], arr2[], n, m):
    Initialize an empty set s
    
    // Step 1: Insert elements of arr1 into the set
    For i = 0 to n - 1:
        Insert arr1[i] into s
    
    // Step 2: Insert elements of arr2 into the set
    For i = 0 to m - 1:
        Insert arr2[i] into s
    
    // Step 3: Initialize an empty vector to store the result
    Initialize vector unionResult
    
    // Step 4: Transfer elements from set to vector
    For each element in set s:
        Add element to unionResult
    
    // Step 5: Return the vector with union of elements
    Return unionResult
```

2. **Optimal Approach**: We can use the two pointer approach to solve this problem. We will initialize pointers `i` and `j` which point to the first elements of both arrays respectively. Now we create a new union array, in which we add elements of our first two arrays.

Note, that our input arrays are sorted - and we want our union arrays to be sorted as well. Therefore, on each iteration, we check for the lowest of the two pointers and add them to our union array. If `i` was smaller than `j`, we add `i` to the union array. Then we increment the `i` pointer. So anytime we add a pointer's element to our array, we increment that pointer.

If both pointer's value are equal, we can pick our choice.

But, note that, our union is supposed to be unique - so whenever we want to add to our union array, we need to check if it already contains the element to be added. 

If the iteration of one array is over, we will continue the iteration from the other portion of the array, and add its elements into our union.

Below is a **pseudocode**
```pseudocode
Function findUnion(arr1[], arr2[], n, m):
    Initialize pointers i = 0, j = 0
    Initialize an empty vector unionResult
    
    While i < n and j < m:
        If arr1[i] < arr2[j]:
            If unionResult is empty or last element of unionResult != arr1[i]:
                Add arr1[i] to unionResult
            Increment i
        Else if arr1[i] > arr2[j]:
            If unionResult is empty or last element of unionResult != arr2[j]:
                Add arr2[j] to unionResult
            Increment j
        Else:
            If unionResult is empty or last element of unionResult != arr1[i]:
                Add arr1[i] to unionResult
            Increment i
            Increment j

    While i < n:
        If unionResult is empty or last element of unionResult != arr1[i]:
            Add arr1[i] to unionResult
        Increment i

    While j < m:
        If unionResult is empty or last element of unionResult != arr2[j]:
            Add arr2[j] to unionResult
        Increment j
    
    Return unionResult
```

Below is a **c++ solution**
```cpp
vector < int > sortedArray(vector < int > a, vector < int > b) {
    // Write your code here
    int n1 = a.size();
    int n2 = b.size();

    int i = 0, j = 0;

    vector<int> unionArr;

    while(i < n1 && j < n2){
        if (a[i] <= b[j]){
            if(unionArr.size() == 0 || unionArr.back() != a[i]){
                unionArr.push_back(a[i]);
            }
            i++;
        } else{
            if(unionArr.size() == 0 || unionArr.back() != b[j]){
                unionArr.push_back(b[j]);
            }
            j++;
        }
    }

    while (i < n1) {
        if (unionArr.empty() || unionArr.back() != a[i]) {
            unionArr.push_back(a[i]);
        }
        i++;
    }

    while (j < n2) {
        if (unionArr.empty() || unionArr.back() != b[j]) {
            unionArr.push_back(b[j]);
        }
        j++;
    }

    return unionArr;
}
```