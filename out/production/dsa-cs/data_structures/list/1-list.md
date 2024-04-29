Lists are probably the most used built-in data structures in Python because they can be
composed of any number of other data types. They are a simple representation of arbitrary
objects. Like strings, they are indexed by integers starting with zero. The following table
contains the most commonly used list methods and their descriptions


## List methods

1. list(s) Returns a list of the sequence s.

2. s.append(x) Appends element x to the end of s.

3. s.extend(x) Appends the list x to s.

4. s.count(x) Counts the occurrence of x in s.

5. s.index(x, [start], [stop]) Returns the smallest index, i, where s[i] ==x. Can include optional start and stop index for the search.

6. s.insert(i,e) Inserts x at index i.

7. s.pop(i) Returns the element i and removes it from the list.

8. s.remove(x) Removes x from s.

9. s.reverse() Reverses the order of s.

10. s.sort(key ,[reverse]) Sorts s with optional key and reverse

## List Operations

1. Indexing - [ ] - Access an element of a sequence
2. Concatenation - + - Combine sequences together
3. repetition - * - Concatenate a repeated number of times
4. membership - in - Ask whether an item is in a sequence
5. length - len - Ask the number of items in the sequence
6. slicing - [ : ] - Extract a part of a sequence