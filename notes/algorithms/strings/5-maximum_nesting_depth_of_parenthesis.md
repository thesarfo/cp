
#### Problem Statement
Given a valid parentheses string `s`, return the maximum nesting depth of the parentheses. 

[problem link](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/)

**Examples**:
1. Input: `"(1+(2*3)+((8)/4))+1"` → Output: `3`
2. Input: `"(1)+((2))+(((3)))"` → Output: `3`
3. Input: `"()(())((()()))"` → Output: `3`

#### Key Concepts

- **Nesting Depth**: The maximum number of open parentheses before a closing one. 
- **Valid Parentheses**: The string consists only of `(`, `)`, and is guaranteed to be a valid expression.

#### Why Use a Stack?
- **LIFO Principle**: The Last In, First Out nature of stacks aligns with how parentheses work (the most recently opened must close first).
- **Depth Tracking**: Each push indicates a deeper level of nesting; each pop indicates a return to a shallower level.
- **Matching Parentheses**: Stacks effectively handle the pairing of parentheses.

#### Stack Operations
1. **Push**: Add an element to the top of the stack.
   - **When**: Encounter an opening parenthesis `'('`.
2. **Pop**: Remove the top element from the stack.
   - **When**: Encounter a closing parenthesis `')'`.
3. **Size**: Returns the number of elements in the stack.
   - **When**: Used to determine the current depth after each push.

#### Implementation Steps
1. Initialize an empty stack and a variable `maxDepth` to zero.
2. Traverse the string character by character:
   - If `'('`: Push onto the stack and update `maxDepth` with the current size of the stack.
   - If `')'`: Pop from the stack.
3. Return `maxDepth`.

#### Java Implementation
```java
import java.util.Stack;

public class MaximumNestingDepth {
    public static int maxDepthUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);  // Push on '('
                maxDepth = Math.max(maxDepth, stack.size());  // Update max depth
            } else if (c == ')') {
                stack.pop();  // Pop on ')'
            }
        }

        return maxDepth;
    }
}
```

#### Complexity
- **Time Complexity**: O(n), where n is the length of the string (one traversal).
- **Space Complexity**: O(n) in the worst case (if all characters are `(`).

