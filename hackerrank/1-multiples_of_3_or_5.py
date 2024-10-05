def solution(n):
    final = []
    for i in range(n):
        if i % 3 == 0 or i % 5 == 0:
            final.append(i)
    return sum(final)

# a more efficient solution with 0(1)

#!/bin/python3

import sys


t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())

    n -= 1
    n3 = n // 3
    n5 = n // 5
    n15 = n // 15
    
    sum_3 = 3 * (n3 * (n3 + 1)) // 2
    sum_5 = 5 * (n5 * (n5 + 1)) // 2
    sum_15 = 15 * (n15 * (n15 + 1)) // 2
    
    print(sum_3 + sum_5 - sum_15)