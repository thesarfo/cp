

# importing "array" for array operations
import array
  
# initializing array with array values and signed integers
arr = array.array('i', [1, 2, 3]) 
 
# printing original array
print ("The new created array is : ",end=" ")
for i in range (0, 3):
    print (arr[i], end=" ")
print("\r")
 
# using append() to insert new value at end
arr.append(4)
 
# inserting int 5 at index 2
arr.insert(2, 5)

# removing element at index 3
arr.pop(3)

# remove first occurrence of int 1
arr.remove(1)

# return first occurence of item at index 4
arr.index(4)

# reversing an array
arr.reverse()