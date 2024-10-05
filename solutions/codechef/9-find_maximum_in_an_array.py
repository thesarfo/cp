t = int(input())

for _ in range(t):
    N = int(input())
    max = 0
    for i in range(N):
        height = int(input())
        if height > max:
            max = height
    print(max)