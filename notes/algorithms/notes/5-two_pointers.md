* It is normally used for searching and it uses two pointers in one loop over the given data structure. It is a common approach for solving coding problems mostly related to strings, arrays and linked lists.

* It is a strategy for traversing an array with two pointers to find pairs of numbers. 

* In order to use this technique, most of the time the data structure needs to be ordered in some way. Which helps us to reduce the time complexity from 0(n2) or 0(n3) to 0(n).

So depending on whether the data structure is sorted or not, the two pointer method can take O(nlogn) time, or even better with is 0(n).

There are two types of variations for this algorithm.

1. Slow pointer and fast pointer. (Equi-directional)
You have a slow and a fast pointer which both move at a different pace. These are commonly used in linked list problems.

2. One at the front, and one at the end of the array.(Opposite directional)
We gradually move both pointers toward the center of the array.

The most common problem this algorithm is used is the `two sum` problem. As below;
Given an array of sorted integers, find two numbers such that they add up to a target number.

So we have a lower pointer and a higher pointer. We now have a starting sum(low + high). Because the array is sorted, and if we were to move the right index backward, we will have a smaller sum. By moving the left index forward, we will have a larger sum.

Let's take this example 
```java
Input: nums = [-3,2,3,3,6,8,15], target = 6
Output: [2, 3]
Explanation: Because nums[2] + nums[3] == 6, we return [2, 3].
```
Our lower pointer will be at `-3`, and our higher pointer will be at `15`. Now since we have to return the index of the two integers that sum up to 9. Here is how we can approach this solution.

We have to make sure that our pointers cant cross each other. we can do that by ensuring that the left pointer is always less than the right pointer.
If we sum our pointers and the result is higher than our `target`, we will have to move the right pointer backward(because the list is sorted). Same way if the result of adding the low and high pointer is smaller than our `target`, we have to move the left pointer forward. We keep on doing this until, the result of adding our lower and higher pointer is equal to our target. And then return the index of both pointers.

<img src="../images/two pointer.png">

Below is the solution in code, for this algorithm
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[] { nums[left], nums[right] };
            } else if (sum <= target){
                left++;
            } else{
                right--;
            }
        }
        return new int[2];
    }
}
```

### EquiDirectional
Another way of implementing the two-pointer technique is by using the concept of slow and fast pointers. Let's say we have a linked list, and we want to find out if there is a cycle in the linked list. How would we detect the cycle. We can also use two pointers here.

The idea is to move the fast pointer, twice as fast as the slow pointer, and what happens is that the distance between them increases by 1 in each step. If at some point, both pointers meet, then it means there is a cycle in the linked list. If not then there is no cycle in the linked list.

This is how the code implementation would look like.
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) return true;
        }
        return false;
    }
}
```