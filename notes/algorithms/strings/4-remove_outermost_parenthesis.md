**Problem Link:** [LeetCode 1021](https://leetcode.com/problems/remove-outermost-parentheses/)  

#### **Problem Explanation:**  
We are given a valid parentheses string composed of multiple **primitive** valid substrings. Our goal is to **remove the outermost parentheses** from each primitive substring while keeping the structure of the remaining parentheses unchanged.  

#### **Key Concept: Primitive Parentheses Strings**  
A **primitive** valid parentheses string is a non-empty valid substring that **cannot be split further** into smaller valid parts.  

🔹 Example of primitive substrings:  
- `"(()())(())"` → `"(()())"` and `"(())"` are separate primitive parts.  

#### **Approach & Thought Process:**  
We iterate through the string while keeping track of the depth of nested parentheses using a counter.  

- **Use `parenthesesCount` to track open parentheses:**  
  - Increase when encountering `'('`  
  - Decrease when encountering `')'`  

- **When to add characters to the result?**  
  - Only add `'('` if it's **not the first** in a primitive substring.  
  - Only add `')'` if it's **not the last** in a primitive substring.  

---

### **Code Walkthrough:**  
```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder(); // To store final output
        int parenthesesCount = 0; // Tracks nested level

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                if (parenthesesCount > 0) { // Ignore outermost '('
                    result.append(currentChar);
                }
                parenthesesCount++; // Increase count for nested '('
            } else { // If currentChar is ')'
                parenthesesCount--; // Decrease count for closing ')'
                if (parenthesesCount > 0) { // Ignore outermost ')'
                    result.append(currentChar);
                }
            }
        }
        return result.toString();
    }
}
```

---

### **Example Walkthrough:**  
#### **Example 1:**  
**Input:**  
```text
s = "(()())(())"
```
**Step-by-Step Execution:**  
| Character | `parenthesesCount` Before | Action | `parenthesesCount` After | `result` |
|-----------|---------------------------|--------|--------------------------|----------|
| `(` | 0 | **Ignore (outermost)** | 1 | `""` |
| `(` | 1 | **Add to result** | 2 | `"("` |
| `)` | 2 | **Add to result** | 1 | `"()"` |
| `(` | 1 | **Add to result** | 2 | `"()("` |
| `)` | 2 | **Add to result** | 1 | `"()()"` |
| `)` | 1 | **Ignore (outermost)** | 0 | `"()()"` |
| `(` | 0 | **Ignore (outermost)** | 1 | `"()()"` |
| `(` | 1 | **Add to result** | 2 | `"()()("` |
| `)` | 2 | **Add to result** | 1 | `"()()()"` |
| `)` | 1 | **Ignore (outermost)** | 0 | `"()()()"` |

**Final Output:**  
```text
"()()()"
```

---

### **Complexity Analysis:**  
- **Time Complexity:** `O(n)`, where `n` is the length of the input string. We iterate through `s` once.  
- **Space Complexity:** `O(n)`, since we store the modified string in `StringBuilder`.  

---

### **Key Takeaways:**  
✅ The first `'('` and the last `')'` of each primitive substring are **ignored**.  
✅ The remaining parentheses are **added to the result** while maintaining order.  
✅ This approach efficiently removes the outermost layer **without needing extra data structures** like stacks.  