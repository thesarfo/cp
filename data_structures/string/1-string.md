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