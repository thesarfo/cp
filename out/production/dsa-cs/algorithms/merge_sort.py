''' 
The merge sort algorithm consists of three simple steps:
1. Recursively sort the left half of the input array.
2. Recursively sort the right half of the input array.
3. Merge two sorted sub arrays into one. 
'''

def mergeSort(A):
    if len(A) > 1:
        print("splitting ", A)
        mid = len(A) // 2
        left = A[:mid]
        right = A[mid:]

        mergeSort(left)
        mergeSort(right)

        i = j = k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                A[k] = left[i]
                i = i+1
            else:
                A[k] = right[j]
                j = j + 1
            k = k + 1

        while i<len(left):
            A[k]=left[i]
            i=i+1
            k=k+1
        
        while j<len(right):
            A[k]=right[j]
            j=j+1
            k=k+1
        print('merging ', A)
        return(A)

print(mergeSort([120, 140, 1, 33, 99]))