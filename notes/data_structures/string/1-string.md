Strings are immutable sequence objects, with each character representing an element in the
sequence. As with all objects, we use methods to perform operations. Strings, being
immutable, do not change the instance; each method simply returns a value. This value can
be stored as another variable or given as an argument to a function or method.

## String Methods
1. s.count(substring, [start,end]) - Counts the occurrences of a substring with optional start and end parameters.

2. s.expandtabs([tabsize]) - Replaces tabs with spaces.

3. s.find(substring, [start, end]) - Returns the index of the first occurrence of a substring or returns -1 if the substring is not found.

4. s.isalnum() - Returns True if all characters arealphanumeric, returns False otherwise.

5. s.isalpha() Returns True if all characters are alphabetic, returns False otherwise.

6. s.isdigit() Returns True if all characters are digits, returns False otherwise.

7. s.join(t) Joins the strings in sequence t.

8. s.lower() Converts the string to all lowercase.

9. s.replace(old, new [maxreplace]) Replaces old substring with new substring.

10. s.strip([characters]) Removes whitespace or optional characters.

11. s.split([separator], [maxsplit]) Splits a string separated by whitespace or an optional separator. Returns a list.

## String methods in Java
1. s.charAt(index); - returns the character at the specified index. 

2. s.compareTo(t); - compares string s to string t, lexicographically

3. s.concat(t); - appends string t to the end of string s

4. s.contains(t); - check if string s contains string t sequentially, returns a true/false value.

5. s.endsWith(t); - checks if string s ends with string t, sequentially

6. s.equals(t); - checks if string s is the same as string t

7. s.indexOf(t); - searches string s for the first occurence of string t. and returns the index in which string t starts

8. s.lastIndexOf(t); - searches string s for the last occurrence of string t.

9. s.isEmpty(); - returns true if s is empty, false if not

10. s = String.join(" ", "Orange", "apple", "mango"); - joins the strings with a space between them. you can replace the string with anything and it will join the strings with what you specify

11. s.length(); - returns the number of characters in the string

12. s.replace('l', 'p'); - return string s, but all characters 'l' in string s, will be replaced with 't'

13. s.startsWith(t); - returns true if s starts with t sequentially. false if not

14. s.subSequence(7, 12); - returns the characters in string s, from index 7 to 12(exclusive)

15. s.subString(7, 12); - returns a substring from string s. if the end argument is not specified then the substring will end at the end of the string

16. s.trim(); - removes whitespaces from both sides of string s.