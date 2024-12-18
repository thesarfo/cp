import math

def NthRoot(n: int, m: int) -> int:
    low, high = 0, m

    while low <= high:
        mid = (low + high) // 2
        power = math.pow(mid, n)

        if power == m:
            return mid
        elif power > m:
            high = mid - 1
        else:
            low = mid + 1
            
    return -1  
