t = int(input())           
for i in range(t):
    X = int(input())
    if X > 100:
        new_X = X - 10
        print(new_X)
    else:
        print(X)