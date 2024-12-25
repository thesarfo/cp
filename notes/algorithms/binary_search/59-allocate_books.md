You are given an array of integers `arr[]`, where `arr[i]` represents the number of pages in the `i-th` book. There are `m` students, and you need to allocate books such that:

1. Each student gets at least one book.
2. Each book is assigned to exactly one student.
3. Books are assigned in a **contiguous** manner.
4. Minimize the **maximum number of pages** assigned to any student.

If it is not possible to allocate books, return `-1`.

In other words, this problem wants us to allocate the books to each student such that the maximum books 1 student can get is also the minimum.

[Problem Link](https://www.naukri.com/code360/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries)



### **Observation:**

To minimize the **maximum pages** assigned to a student, we must balance the workload between students. Assigning books in **contiguous blocks** ensures fairness.

The question is analogous to finding a distribution strategy where the **maximum pages any student reads is minimized**. This involves testing various ways to distribute the books and selecting the optimal strategy.


### **Approach:**

#### 1. Define the Search Space:

The minimum possible maximum pages is the **largest book** (a single student reads it).  
The maximum possible pages is the **sum of all pages** (a single student reads all books).

#### 2. Binary Search to Optimize:

We use **binary search** on the range `[max(arr), sum(arr)]` to find the smallest maximum value that satisfies the constraints.

For a given middle value (`mid`), check if it is possible to allocate books such that no student reads more than `mid` pages. If yes, try for a smaller maximum by moving left (`high = mid - 1`). Otherwise, move right (`low = mid + 1`).

#### 3. Feasibility Check:

To check if `mid` is feasible:

- Allocate books to students greedily while ensuring the current total for a student doesn’t exceed `mid`.
- If you need more than `m` students, `mid` is not feasible.


### **Steps:**

1. **Sort the Books:** Sorting is not needed for this problem since the books are allocated in their given order.
   
2. **Binary Search on Maximum Pages:**

   - Initialize `low = max(arr)` and `high = sum(arr)`.
   - Calculate `mid = (low + high) // 2`.
   - Check feasibility of `mid`:
     - Try allocating books to students without exceeding `mid` pages per student.
     - If feasible, reduce `high` to explore smaller maximums.
     - If not feasible, increase `low`.

3. **Output the Result:** The smallest `mid` that passes the feasibility check is the solution.

---

### **Code Implementation:**

```java
public class BookAllocation {
    static int minimizeMaxPages(int[] books, int students) {
        if (students > books.length) {
            return -1; // Not enough books for each student to get one
        }

        // Define the search space
        int low = getMax(books); // Minimum possible max pages
        int high = getSum(books); // Maximum possible max pages
        int result = -1;

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(books, students, mid)) {
                result = mid; // Store the result
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result;
    }

    static boolean isFeasible(int[] books, int students, int maxPages) {
        int studentCount = 1; // Start with the first student
        int currentSum = 0;

        for (int pages : books) {
            if (currentSum + pages > maxPages) {
                studentCount++; // Allocate to the next student
                currentSum = pages; // Reset the sum for the new student

                if (studentCount > students) {
                    return false; // More students required than available
                }
            } else {
                currentSum += pages; // Add pages to the current student's total
            }
        }

        return true; // Allocation successful
    }

    static int getMax(int[] books) {
        int max = 0;
        for (int pages : books) {
            max = Math.max(max, pages);
        }
        return max;
    }

    static int getSum(int[] books) {
        int sum = 0;
        for (int pages : books) {
            sum += pages;
        }
        return sum;
    }
}
```

---

### **Explanation of the Code:**

1. **Search Space:** `low` starts as the maximum book size (`getMax`), and `high` is the total of all pages (`getSum`).

2. **Binary Search:** For each `mid` (candidate for max pages per student), check feasibility using the `isFeasible` function.

3. **Feasibility Check:**
   - Allocate books one by one, summing their pages for the current student.
   - If adding a book exceeds `mid`, allocate the book to a new student.
   - If the number of students exceeds `m`, the allocation is not feasible.

4. **Result:** The smallest feasible `mid` is the answer.


### **Time Complexity:**

1. **Binary Search:** O(log({sum} - {max}))
2. **Feasibility Check:** O(n) per iteration of binary search.

Overall: O(nlog(sum - max))



### **Space Complexity:**

- \(O(1)\), as no additional data structures are used.



### Key Differences from Aggressive Cows:

1. In **Aggressive Cows**, the goal is to maximize the minimum distance between cows, while in **Book Allocation**, the goal is to minimize the maximum pages assigned to a student.
2. Both problems leverage **Binary Search on the answer space** and use a **greedy feasibility check**.