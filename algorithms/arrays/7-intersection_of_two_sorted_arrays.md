The **intersection** of two arrays simply refers to the elements that appear in both arrays(sorted). For instance, given an array `[1, 2, 2, 3, 3, 4, 5, 6]` and another array `[2, 3, 3, 5, 6, 6, 7]`, the intersection will be `[2, 3, 3, 5, 6]`. Duplicates can be allowed in intersections, which is why the `3` appears twice.

1. **Brute Force Solution**: For every element, there should be a corresponding element in the other array. We will pick up each element in the first array, and check if it exists in the second array, if it does, we add it to our union array. But we keep track of if an element has previously been used.

* Iterate over the first array: For each element in the first array, check if that element exists in the second array
* Tracking visited elements in the second array: Since duplicates are allowed, we need to keep track of which elements in the second array have been "used". We can create a visited array of the same size as the second array to mark if an element has been included in the intersection.
* If a match is found: Add the element to the result and mark it as visited in the second array

An implementation in python would look like this

```python
def array_intersection_brute_force(arr1, arr2):
    # Resultant array for the intersection
    result = []
    
    # Visited array to track used elements in arr2
    visited = [False] * len(arr2)
    
    # Iterate over arr1 to check each element
    for i in range(len(arr1)):
        # For each element in arr1, check in arr2
        for j in range(len(arr2)):
            if arr1[i] == arr2[j] and not visited[j]:
                result.append(arr1[i])
                visited[j] = True  # Mark as visited
                break  # Move to the next element in arr1 after a match
                
    return result

# Example usage:
arr1 = [1, 2, 2, 3, 3, 4, 5, 6]
arr2 = [2, 3, 3, 5, 6, 6, 7]

print(array_intersection_brute_force(arr1, arr2))

```

2. **Optimal Approach(two pointers)**: We can keep a pointer at the first array index and another pointer at the second array index.  Since the array is sorted, we can check if both pointers are equal, if they are, its an intersection so we add it to our intersection array. If not, we move both pointers forward.

The **two-pointer** technique is an optimal solution when dealing with sorted arrays. By leveraging the fact that the arrays are sorted, we can efficiently find the intersection of the two arrays in linear time by moving pointers accordingly.

1. **Initialize two pointers**: Start both pointers at the beginning of the two arrays (let's call them `i` and `j`).
  
2. **Compare elements at both pointers**:
    - If the elements are the same, add the element to the result and move both pointers forward.
    - If the element in the first array is smaller, move the pointer in the first array forward.
    - If the element in the second array is smaller, move the pointer in the second array forward.
  
3. **Continue this process until one of the arrays is exhausted**.

### Code Implementation:

```python
def array_intersection_two_pointers(arr1, arr2):
    result = []
    i, j = 0, 0  # Initialize pointers for both arrays
    
    # Loop until one of the arrays is fully traversed
    while i < len(arr1) and j < len(arr2):
        if arr1[i] == arr2[j]:  # Both elements are equal
            result.append(arr1[i])
            i += 1
            j += 1
        elif arr1[i] < arr2[j]:  # Move the pointer in arr1 forward
            i += 1
        else:  # Move the pointer in arr2 forward
            j += 1
    
    return result

# Example usage:
arr1 = [1, 2, 2, 3, 3, 4, 5, 6]
arr2 = [2, 3, 3, 5, 6, 6, 7]

print(array_intersection_two_pointers(arr1, arr2))
```

### Explanation:
1. **Pointers (`i` and `j`)**: These are initialized at the start of both arrays. They are used to traverse through both arrays in sync.
2. **Comparing elements**: If the element in the first array is smaller, it cannot be part of the intersection, so we move the pointer `i` in `arr1` forward. Similarly, if the element in `arr2` is smaller, we move the pointer `j` forward.
3. **Equal elements**: If both pointers point to the same value, it's part of the intersection, and we add it to the result.
4. **Terminating condition**: The loop terminates when one of the arrays has been completely traversed.