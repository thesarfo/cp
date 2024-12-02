You are given a sentence and a search word. Your task is to find the first word in the sentence that starts with the `searchWord` as prefix. Let's analyse this:

* **Prefix of a string**: A prefix refers to any leading part of the string. For instance, the prefix of "burger" can be "bur", "burg" or even "burger". We want to check if the `searchWord` is the prefix of any word in the sentence.

* **Sentence structure**: The sentence consists of words separated by a single space. So, we can break the sentence into a list of words and check each word to see fi it starts with the `searchWord`.

[Leetcode Problem](https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description)

### Plan

1. **Split the sentence into words**:
    - The words are separated by spaces. So, we can split the sentence into a list of words using the space as a delimiter.

2. **Check each word**:
    - For each word in the list, check if the searchWord is a prefix of the word.
    - The method to check if a word starts with a prefix in Java is startsWith().

3. **Return the 1-indexed position**:
    - If the word starts with the searchWord, return the index of that word (1-indexed).
    - If no word starts with the searchWord, return -1.

**Edge Cases:** <br>
- If the `searchWord` is longer than any word in the sentence, we can immediately return -1 as no word can start with a longer string.
- If the `searchWord` doesn't match any word, return `-1`.



### Steps

1. **Step 1**: Split the sentence into words.
2. **Step 2**: Iterate through each word and check if it starts with the `searchWord` using the `startsWith()` method.
3. **Step 3**: Return the 1-based index of the first match.
4. **Step 4**: If no match is found, return `-1`.

### Code Implementation:

```java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Step 1: Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Step 2: Iterate through the words and check if searchWord is a prefix
        for (int i = 0; i < words.length; i++) {
            // Step 3: If the word starts with searchWord, return the 1-indexed position
            if (words[i].startsWith(searchWord)) {
                return i + 1; // 1-indexed
            }
        }
        
        // Step 4: If no match is found, return -1
        return -1;
    }
}
```