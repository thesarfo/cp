You are given an array containing elements that appear twice in the array except for one. Your goal is to find the element that appears only once. For instance, given an array `[1, 1, 2, 3, 3, 4, 4]`, the answer will be `2`, since it is the only element that appears once.

[Leetcode 136](https://leetcode.com/problems/single-number/description/)

1. **Brute Force Approach**: You will pick each element, and perform another linear search in the array and find if that number appears again in the array. 0(n * n)

```java
class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == num) count++;
            }
            if(count == 1) return num;
        }
        return -1;

    }
}
```


2. **Better Solution**: We can use hashing to tell who appear once. But what data structure can we use for this solution. We can use an array, but it wouldn't be suitable for larger inputs. So perhaps, we can go with a `map` instead, with a large data type as they key, and an integer as its value.

We will create a map where the key is the element from the array, and the value is the count of occurrences of that element. We then traverse the array and update the count for each element in the map. Finally, we traverse the map to find the key with a count of 1.

```pseudocode
// Step 1: Create a map to store frequency of each element
map<int, int> frequency_map;

// Step 2: Populate the map with counts
for(i = 0 -> n-1) {
    frequency_map[arr[i]]++;
}

// Step 3: Find the element with a count of 1
for each (entry in frequency_map) {
    if (entry.value == 1) {
        return entry.key;
    }
}

```

Below is a java implementation 

```java
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
```

- **Time Complexity**: `O(n)`. We traverse the array once to populate the map and then traverse the map to find the unique element.
- **Space Complexity**: `O(n)`. The space complexity is proportional to the number of unique elements in the array.

3. **Optimal Solution**: Every number appears twice except one. Remember the `XOR` operator? if every number appears twice, if we do a XOR of all the elements, they will cancel out - except 1 element which wouldn't cancel out because it only appears once.

```pseudocode
xor = 0;

for(int i = 0 -> n){
	xor = xor ^ arr[i]
}
return xor
```

Time Complexity = O(n), Space Complexity = 0(1).