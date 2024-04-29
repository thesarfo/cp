a set is an unordered collection of zero or more immutable Python data objects.

```python
>>> {3, 6, "cat", False}
```

### Operations on a set in python
1. membership - in - Set membership

2. length - len - Returns the cardinality of the set

3. | - aset | otherset -Returns a new set with all elements from both sets

4. & - aset & otherset - Returns a new set with only those elements common to both sets

5. -  -  aset - otherset - Returns a new set with all items from the first set not in second

6. <=  - aset <= otherset - Asks whether all elements of the first set are in the second


## Set Methods

1. union - aset.union(otherset) - Returns a new set with all elements from both sets
2. intersection - aset.intersection(otherset) - Returns a new set with only those elements common to both sets
3. difference - aset.difference(otherset) - Returns a new set with all items from first set not in second
4. issubset - aset.issubset(otherset) - Asks whether all elements of one set are in the other
5. add - aset.add(item) - Adds item to the set
6. remove - aset.remove(item) - Removes item from the set
7. pop - aset.pop() - Removes an arbitrary element from the set
8. clear - aset.clear() - Removes all elements from the set