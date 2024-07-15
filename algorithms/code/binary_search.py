# mid = (low + high) / 2

# We consider three cases:
# • If the target equals data[mid], then we have found the item we are looking for, and the search terminates successfully.
# • If target < data[mid], then we recur on the first half of the sequence, that is, on the interval of indices from low to mid−1.
# • If target > data[mid], then we recur on the second half of the sequence, that is, on the interval of indices from mid+1 to high.
# An unsuccessful search occurs if low > high, as the interval [low,high] is empty

def binary_search(data, target, low, high):
    if low > high:
        return False
    else:
        mid = (low + high) // 2
        if target == data[mid]:
            return binary_search(data, target, low, mid - 1)
        else:
            return binary_search(data, target, mid + 1, high)