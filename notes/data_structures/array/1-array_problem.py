'''Given an array with all distinct elements, find the largest three elements. Expected time complexity is O(n) and extra space is O(1).'''

'''Initialize the largest three elements as minus infinite.
    first = second = third = -?
2) Iterate through all elements of array.
   a) Let current array element be x.
   b) If (x > first)
      {
          // This order of assignment is important
          third = second
          second = first
          first = x   
       }
   c)  Else if (x > second and x != first)
      {
          third = second
          second = x 
      }
   d)  Else if (x > third and x != second)
      {
          third = x  
      }
3) Print first, second and third.'''

import sys

def printlargest(arr, arr_size):
    if (arr_size < 3):
        print("invalid input")
        return
    third = first = second = -sys.maxsize

    for i in range(0, arr_size):
        if (arr[i] > first):
            third = second
            second = first
            first = arr[i]

        elif (arr[i] > second):
            third = second
            second = arr[i]
        
        elif (arr[i] > third):
            third = arr[i]

        print(first, second, third)

# test the above function
arr = [13, 34, 56, 23, 33, 11]
n = len(arr)
printlargest(arr, n)

