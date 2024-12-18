def floorSqrt(n):
   # write your code logic here .
   low = 0
   high = n
   ans = 1

   while(low <= high):
      mid = (low + high) // 2
      if(mid * mid > n):
         high = mid - 1
      else:
         ans = mid
         low = mid + 1
   return ans

n= int(input())
print(floorSqrt(n))