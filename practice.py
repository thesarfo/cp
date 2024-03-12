t = int(input())

for i in range(t):
    A, C = map(int, input().split())
    B = (A + C) // 2
    if B == int(B):
        print(int(B))
    else:
        print(-1)