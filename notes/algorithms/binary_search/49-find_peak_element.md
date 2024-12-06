Imagine you are looking at a mountain range where the peaks are the highest points compared to their immediate neighbors. You are tasked with finding one of those peaks in a list of numbers (`arr`).

[Leetcode 162](https://leetcode.com/find-peak-element)

A **peak element** is any number in the array that is greater than its neighbors. For example:
- If `arr[i]` is the peak, it satisfies `arr[i] > arr[i-1]` and `arr[i] > arr[i+1]`.



### **How to Approach This?**

1. **Visualizing the Peaks:**
   - Peaks could be anywhere in the array. For example:
     - At the start: `arr[0]` can be a peak if it's greater than `arr[1]`.
     - At the end: `arr[n-1]` can be a peak if it's greater than `arr[n-2]`.
     - Anywhere in the middle: Check if `arr[i-1] < arr[i] > arr[i+1]`.

2. **Edge Cases to Consider:**
   - If the array has only **one element**, that element is the peak.
   - If the first element is greater than the second, it's a peak.
   - If the last element is greater than the second-last, it's a peak.

3. **Multiple Peaks:**
   - If there are several peaks, just return the index of **any** peak.

---

### **Ways to Solve**

#### **Brute Force (Straightforward Approach)**
- Loop through every element and check if it satisfies the peak condition.
- For every `i`, check:
  ```python
  if (i == 0 or arr[i-1] < arr[i]) and (i == n-1 or arr[i] > arr[i+1]):
      return i
  ```
- This is simple but takes \(O(n)\) time because you check every element.

---

#### **Optimized Approach (Binary Search)**
We can do better than brute force by using **Binary Search**, which cuts the array in half repeatedly.

1. **Key Insight for Binary Search:**
   - The array around a peak behaves like a hill:
     - On the **left side of a peak**, values are increasing (`arr[i] < arr[i+1]`).
     - On the **right side of a peak**, values are decreasing (`arr[i] > arr[i+1]`).
   - Using this property, we can decide which half of the array to explore.

2. **Steps:**
   - Start with two pointers, `low` (start of array) and `high` (end of array).
   - Calculate the middle index, `mid = (low + high) // 2`.
   - Check if `arr[mid]` is a peak:
     - If `arr[mid] > arr[mid-1]` and `arr[mid] > arr[mid+1]`, return `mid`.
   - If `arr[mid] < arr[mid+1]`, move to the right half (`low = mid + 1`).
   - Otherwise, move to the left half (`high = mid - 1`).
   - Keep doing this until you find a peak.

3. **Time Complexity:**
   - Binary search reduces the array size by half at each step, so it takes \(O(\log n)\) time.

---

### **Intuition Behind the Binary Search**

- Imagine walking along a trail with ups and downs:
  - If you're climbing (increasing values), the peak is ahead, so you go forward.
  - If you're descending (decreasing values), the peak is behind, so you go back.
  - At the top, where both sides go down, you're at the peak.

---

Below is a code sample

```python
def findPeakElement(arr):
    n = len(arr)

    # Edge cases
    if n == 1:  # Single element is always the peak
        return 0
    if arr[0] > arr[1]:  # First element is the peak
        return 0
    if arr[n-1] > arr[n-2]:  # Last element is the peak
        return n-1

    # Binary search
    low, high = 1, n - 2  # Start excluding edges (already checked)
    while low <= high:
        mid = (low + high) // 2

        # Check if mid is a peak
        if arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]:
            return mid

        # Move to the side where the peak might exist
        if arr[mid] < arr[mid+1]:  # Move right
            low = mid + 1
        else:  # Move left
            high = mid - 1

    return -1  # Failsafe, though we should always find a peak

# Example usage
arr = [1, 3, 20, 4, 1, 0]
print("Peak is at index:", findPeakElement(arr))
```

---

### **Key Points to Remember**
1. A peak is any element greater than its neighbors.
2. Check edge cases for small arrays and boundary elements.
3. Use **binary search** for efficiency by leveraging the increasing/decreasing pattern around peaks.
4. Multiple peaks? Return any one — both brute force and binary search handle this.