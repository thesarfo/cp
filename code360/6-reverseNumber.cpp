#include <bits/stdc++.h>
long long int reverseNumber(long long int n)
{
	//type your code here
	long revN = 0;

        while (n > 0) {
          long lastDigit = n % 10;
          n = n / 10;

          revN = (revN * 10) + lastDigit;
        }
        return revN;
}
