a set is an unordered collection of zero or more immutable Python data objects.

```python
>>> {3, 6, "cat", False}
```

#### Operations on a set in python
1. membership - in - Set membership

2. length - len - Returns the cardinality of the set

3. | - aset | otherset -Returns a new set with all elements from both sets

4. & - aset & otherset - Returns a new set with only those elements common to both sets

5. -  -  aset - otherset - Returns a new set with all items from the first set not in second

6. <=  - aset <= otherset - Asks whether all elements of the first set are in the second

see below
```python
mySet
{False, 4.5, 3, 6, 'cat'}
len(mySet)
5
False in mySet
True
"dog" in mySet
False
```