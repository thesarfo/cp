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