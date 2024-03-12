t = int(input())

for i in range(t):
    A, C = map(int, input().split())
    B = (A + C) / 2
    if B == int(B):
        print(int(B))
    else:
        print(-1)

# alt solution
t = int(input())            
for i in range(t):          
    A, C = map(int, input().split())
    B = (A + C) // 2
    if A % 2 == 0 and C % 2 == 0:
        print(B)
    elif A % 2 != 0 and C % 2 != 0:
        print(B)
    else:
        print(-1)