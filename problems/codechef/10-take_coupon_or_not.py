t = int(input())

while t > 0:
    n, x, y = map(int, input().split())
    a = list(map(int, input().split()))
    t -= 1
    
    total_cost_without_coupon = sum(a)
    
    discounted_prices = [max(0, price - y) for price in a]
    total_cost_with_coupon = sum(discounted_prices) + x
    
    if total_cost_with_coupon < total_cost_without_coupon:
        print("COUPON")
    else:
        print("NO COUPON")