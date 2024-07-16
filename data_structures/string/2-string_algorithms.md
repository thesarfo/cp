## 1. Palindrome
A palindrome is a string that reads the same backwards and forwards. Here is how to check for palindromes:

What we do is that we basically reverse the string, and store it in a new variable, then we compare if the original string is equal to its reversed counterpart. If it is, then it is a valid palindrome
```python
def is_palindrome(str):
  return str == str[::-1]
```

```java
public boolean isPalindrome(String str) {
  String reversed = new StringBuilder(str).reverse().toString();
  return str.equals(reversed);
}
```

## 2. Anagrams
Two strings are anagrams if they contain the same characters in different orders. This is how to check: The easiest thing to do is to break apart a string into an array, sort, and join back to a string again. After joining, we compare if they're equal; if yes, then it is a valid anagram.

```java
public boolean isAnagram(String str1, String str2) {
  char[] charArray1 = str1.toCharArray();
  char[] charArray2 = str2.toCharArray();
  Arrays.sort(charArray1);
  Arrays.sort(charArray2);
  return Arrays.equals(charArray1, charArray2);
}
```

```python
def isAnagram(str1, str2):
    return Counter(str1) == Counter(str2)
```
