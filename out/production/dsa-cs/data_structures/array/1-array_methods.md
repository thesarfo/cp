The array objects support the following attributes and methods:

## Array Methods

1. a.typecode - The typecode character used to create the array.

2. a.itemsize - Size, in bytes, of items stored in the array.

3. a.append(x) - Appends item x to the end of the array.

4. a.buffer_info() - Returns the memory location and length of the buffer used to store

the array.
5. a.byteswap() - Swaps the byte order of each item. Used for writing to a machine or

file with a different byte order.
6. a.count(x) - Returns the number of occurrences of x in a.

7. a.extend(b) - Appends any iterable, b, to the end of array a.

8. a.frombytes(s) - Appends items from a string, s, as an array of machine values.

9. a.fromfile(f, n) - Reads n items, as machine values, from a file object, f, and appends them to a. Raises an EOFError if there are fewer than n items in n.

10. a.fromlist(l) - Appends items from list l.

11. a.fromunicode(s) - Extends a with unicode string s. Array a must be of type u or else ValueError is raised.

index(x) Returns the first (smallest) index of item x.

12. a.insert(i, x) - Inserts item x before index i.

Python Data Types and Structures
[ 60 ]
13. a.pop([i]) - Removes and returns items with index i. Defaults to the last item

(i = -1) if not specified.
14. a.remove(x) - Removes the first occurrence of item x.

15. a.reverse() - Reverses the order of items.

16. a.tobytes() - Convert the array to machine values and returns the bytes representation.

17. a.tofile(f) - Writes all items, as machine values, to file object f.

18. a.tolist() - Converts the array to a list.

19. a.tounicode() - Convert an array to unicode string. The array type must be 'u' or else a ValueError is raised.