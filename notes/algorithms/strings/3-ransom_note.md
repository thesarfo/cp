You are given two strings `ransomNote` and `magazine`, your task is to return **true** if `ransomNote` can be constructed by using letters from `magazine` and **false** otherwise.

Each letter in `magazine` can only be used once in `ransomNote`

For instance
```
Input: ransomNote = "a", magazine = "b"
Output: false
```

Or
```
Input: ransomNote = "aa", magazine = "aab"
Output: true
```

Or even
```
Input: ransomNote = "aa", magazine = "ab"
Output: false
```

[Leetcode 383](https://leetcode.com/problems/ransom-note/description/)

**Constraints**:

* `1 <= ransomNote.length, magazine.length <= 105`
* `ransomNote` and `magazine` consist of lowercase English letters.

<br>

## **Solution 1 - Hash Table or Array**:
We can use a hash table or an array *cnt* of length `26` to record the no. of times each character appears in the string `magazine`. Then, we traverse the string `ransomNote`, for each character *c* in it, we decrease the number of *c* by 1 in *cnt*. If the number of *c* is less than `0` after the decrease, it means that the number of *c* in `magazine` is not enough, so it cannot be composed of `ransomNote` just return **false**.

Otherwise, after the traversal, it means that each character in `ransomNote` can be found in `magazine`. Therefore, return t r u e .

The time complexity is O ( m + n ) , and the space complexity is O ( C ) . Where m and n are the lengths of the strings `ransomNote` and `magazine` respectively; and C is the size of the character set, which is `26` in this question.

Below is a code implementation

**Python3**
```python
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        cnt = Counter(magazine)
        for c in ransomNote:
            cnt[c] -= 1
            if cnt[c] < 0:
                return False
        return True
```

**Java**
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++cnt[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```