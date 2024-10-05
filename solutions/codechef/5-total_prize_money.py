t = int(input())
for i in range(t):
    X, Y = map(int, input().split())
    prize_top10 = 10*X           
    prize_11to100 = 90*Y         
    print((prize_top10)+ (prize_11to100)) 