### Problem Statement

You are given an array, and you need to find the element that appears more than `n/2` times, where `n` is the length of the array. If such an element exists, it's referred to as the **majority element**. For example, if `n = 8`, an element must appear more than `4` times to be considered the majority element.

[Leetcode 169](https://leetcode.com/problems/majority-element/description/)

#### Example:
Given the array `[2, 2, 3, 3, 1, 2, 2]`:
- The length of the array is `7`, so `n/2 = 7/2 = 3` (integer division).
- The number `2` appears **4** times, which is more than `3`, making it the majority element.
- Therefore, the answer is `2`.

---

### Approaches

#### 1. **Brute Force Approach**

We can solve this problem by comparing each element in the array with every other element and counting its occurrences. If the count of an element exceeds `n/2`, then it is the majority element.

##### Pseudocode:
```pseudocode
for(i = 0; i < n; i++) {
    count = 0;

    for(j = 0; j < n; j++) {
        if(arr[j] == arr[i]) {
            count++;
        }
    }

    if(count > n/2) {
        return arr[i];
    }
}

return -1;  // No majority element found
```

##### Time Complexity:
- **O(n²)**: Since we are using nested loops to compare each element with every other element, the time complexity grows quadratically, making this solution inefficient for large arrays.

---

#### 2. **Optimized Solution Using HashMap**

A more efficient approach is to use a `HashMap` (or dictionary) to keep track of the frequency of each element in the array. By iterating over the array once, we can build a frequency map. After that, we iterate through the map to find the element whose count exceeds `n/2`.

##### Steps:
1. Initialize an empty `HashMap` to store element-frequency pairs.
2. Loop through the array and update the count of each element in the map.
3. After processing the array, iterate through the map and check if any element's frequency exceeds `n/2`. If found, return that element.

##### Java Implementation:
```java
int n = nums.length;
HashMap<Integer, Integer> hash = new HashMap<>();

// Count the occurrences of each element
for(int i = 0; i < n; i++) {
    int value = hash.getOrDefault(nums[i], 0);
    hash.put(nums[i], value + 1);
}

// Find the element whose count exceeds n/2
for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
    if(entry.getValue() > (n / 2)) {
        return entry.getKey();  // Majority element found
    }
}

return -1;  // No majority element found
```

##### Time Complexity:
- **O(n)**: We traverse the array once to populate the map, and then we iterate through the map entries, which takes linear time.
- **Space Complexity**: **O(n)** because the map stores frequencies for up to `n` elements.

---

#### 3. **Optimal Solution (Moore's Voting Algorithm)**:

The idea behind this algorithm is that if there is a majority element, it will ultimately emerge as the winner. We start by setting the first choice as teh potential majority element, and we initialize the vote count for that element as 1. Then, we traverse through the remaining choices and compare them to the potential majority element. If the current element in the loop is not the same as our potential majority element, we decrement the vote count for our majority element. If the current element in the loop is the same as our potential majority element, we increment the vote count for our majority element. If at any point in the loop, our vote count becomes `0`(it has been decremented so much that is now `0`), we reset the vote count to `1` and reset our potential majority element to the current element in the loop

Finally, we verify if our potential majority element after the loop is indeed the majority element. This means that we will iterate through the set of choices once more, counting the occurences of our potential majority element. Then, we check if the occurrences is greater than `n/2`. If it is, then it is indeed our majority element.


#### Algorithm Explanation:
1. **Candidate Selection**: We traverse through the array and keep track of a potential majority element (pme) and a counter (count). Initially, both pme and count are uninitialized.

* For each element, if count is 0, we assume the current element is the majority candidate (pme) and set count = 1.
* If the current element matches pme, increment the count.
* If the current element is different, decrement the count.
* If count drops to 0, it means the current pme is no longer a viable candidate, so we reset pme to the current element and set count = 1.


2. **Validation**: Once the array traversal is complete, we may have a candidate (pme), but it’s not guaranteed to be the majority element. So, we count the occurrences of this candidate again. If it appears more than n/2 times, it is the majority element.


Below is a sample implementation in java

```java
public int majorityElement(int[] nums) {
    int pme = 0;  // potential majority element
    int count = 0;

    // Step 1: Find the majority candidate
    for(int i = 0; i < nums.length; i++) {
        if(count == 0) {
            pme = nums[i];  // Reset the candidate
            count = 1;
        } else if(nums[i] == pme) {
            count++;
        } else {
            count--;
        }
    }

    // Step 2: Validate the majority candidate
    int vCount = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] == pme) {
            vCount++;
        }
    }

    // Check if pme is indeed the majority element
    if(vCount > nums.length / 2) {
        return pme;
    }

    return -1;  // No majority element found
}
```

**Time Complexity:**
O(n): We traverse the array twice—once to determine the candidate and once to validate it.

**Space Complexity:** O(1): Only a few variables are used regardless of the array size.