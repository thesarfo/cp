import math

def NthRoot(n: int, m: int) -> int:
    for i in range(1, m + 1):
        power = math.pow(i, n) 
        
        if power == m: 
            return i
        elif power > m: 
            break
            
    return -1  
