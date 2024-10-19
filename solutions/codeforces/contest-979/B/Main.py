t = int(input())
for _ in range(t):
    n = int(input())
    s = ''
    for i in range(n):
        if i == 0:
            s += '1'
        else:
            s += '0'
    print(s)