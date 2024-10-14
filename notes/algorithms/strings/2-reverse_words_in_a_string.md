### Problem: Reverse the Words in a Sentence

Given an input string `s`, reverse the order of the words.

A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

For example:
- Input: `"  the sky  is blue  "`
- Output: `"blue is sky the"`

[Leetcode 151](https://leetcode.com/problems/reverse-words-in-a-string/description/)

We will use a **two-pointer approach** to solve this problem efficiently. See below

---

### Step-by-Step Solution:

#### 1. **Handling Extra Spaces**
The first thing to note is that the input string can have leading, trailing, or extra spaces between words. We need to handle this by:
- Removing unnecessary spaces at the beginning and end of the string.
- Ensuring there is only one space between words.

**How we do this:**
- Use `s.trim()` to remove any leading and trailing spaces.
- Use `split("\\s+")` to split the string into words based on one or more spaces. The `\\s+` is a regular expression that matches one or more whitespace characters (spaces, tabs, etc.).

**Example:**
```java
String[] words = s.trim().split("\\s+");
```
- If `s = "  the sky  is blue  "`, after trimming and splitting:
  - The result of `words` will be: `["the", "sky", "is", "blue"]`.

#### 2. **Reversing the Words**
Now, we have an array of words. Our task is to reverse the order of these words. We can do this efficiently using a **two-pointer approach**.

**Two-Pointer Approach Explained:**
- We start by initializing two pointers:
  - `low` at the beginning of the array (index `0`).
  - `high` at the end of the array (index `words.length - 1`).
- We will swap the word at the `low` pointer with the word at the `high` pointer, then move both pointers towards each other:
  - Increase `low` by 1.
  - Decrease `high` by 1.
- Continue this process until the two pointers cross each other.

**Why two pointers?**
- This is an efficient way to reverse an array in place. We don't need extra space (like creating a new array). By swapping elements directly, we can reverse the array in `O(n)` time complexity, where `n` is the number of words.

**Example:**
- Initially, `words = ["the", "sky", "is", "blue"]`.
- After the first swap, `low = 0`, `high = 3`, the array becomes: `["blue", "sky", "is", "the"]`.
- After the second swap, `low = 1`, `high = 2`, the array becomes: `["blue", "is", "sky", "the"]`.
- Now, `low` is equal to `high`, so we stop.

**Code for Reversing:**
```java
int low = 0;
int high = words.length - 1;

while (low < high) {
    // Swap words[low] and words[high]
    String temp = words[low];
    words[low] = words[high];
    words[high] = temp;
    
    // Move pointers towards each other
    low++;
    high--;
}
```

#### 3. **Joining the Words Back into a Sentence**
Once the words are reversed, we need to join them back into a single sentence.

**How to join the words:**
- Use the `String.join()` method to combine the words, adding a single space between each word.
- This method takes a delimiter (in this case, a space `" "`) and an array of strings (our `words` array).

**Code for Joining:**
```java
return String.join(" ", words);
```

- If `words = ["blue", "is", "sky", "the"]`, this will return the string `"blue is sky the"`.

---

### Full Solution Code:

```java
class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim and split the sentence into words based on spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Use two-pointer approach to reverse the array of words
        int low = 0;
        int high = words.length - 1;
        while (low < high) {
            String temp = words[low];
            words[low] = words[high];
            words[high] = temp;
            low++;
            high--;
        }

        // Step 3: Join the reversed words back into a sentence with a space separator
        return String.join(" ", words);
    }
}
```

---

### Key Concepts:

- **Trimming and Splitting**: We use `trim()` to remove extra spaces and `split("\\s+")` to break the string into words, handling multiple spaces between words.
- **Two-Pointer Technique**: This is an efficient way to reverse the array of words by swapping elements from the start and end until the two pointers meet.
- **Joining Strings**: After reversing, we combine the words back into a single string using `String.join()`.

---

### Time and Space Complexity:

- **Time Complexity**: `O(n)`, where `n` is the number of characters in the string. This includes:
  - Splitting the string into words (`O(n)`).
  - Reversing the array of words (`O(k)`, where `k` is the number of words, and `k <= n`).
  - Joining the words back into a sentence (`O(n)`).

- **Space Complexity**: `O(n)`, since we store the words in an array.

---

### Summary:

1. **Trim and Split** the sentence into words, ignoring extra spaces.
2. **Reverse** the words using a two-pointer technique.
3. **Join** the reversed words into a new sentence with spaces.