#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long factorials[11];
    Solution() {
        factorials[0] = 1;
        for(int i = 1; i <= 10; i++) {
            factorials[i] = factorials[i-1] * i;
        }
    }

    vector<long long> generatePalindromes(int n) {
        vector<long long> palindromes;
        if(n == 0) return palindromes;

        int half_length = (n + 1) / 2;
        long long start = pow(10, half_length - 1);
        long long end = pow(10, half_length) - 1;
        if(n == 1) start = 0;

        for(long long first_half = start; first_half <= end; first_half++) {
            string str_half = to_string(first_half);
            string str_pal;
            if(n % 2 == 0) {
                string rev_half = str_half;
                reverse(rev_half.begin(), rev_half.end());
                str_pal = str_half + rev_half;
            } else {
                string rev_half = str_half.substr(0, str_half.size() - 1);
                reverse(rev_half.begin(), rev_half.end());
                str_pal = str_half + rev_half;
            }

            if(str_pal.size() == n) {
                long long num = stoll(str_pal);
                palindromes.push_back(num);
            }
        }

        return palindromes;
    }

    vector<int> getDigitCounts(long long num, int n) {
        vector<int> counts(10, 0);
        string s = to_string(num);
        while(s.size() < n) s = "0" + s;
        for(char c : s) counts[c - '0']++;
        return counts;
    }

    long long countNumbers(vector<int> counts, int n) {
        long long total = 0;
        for(int d = 1; d <= 9; d++) {
            if(counts[d] == 0) continue;
            vector<int> new_counts = counts;
            new_counts[d]--;
            bool valid = true;
            for(int cnt : new_counts) {
                if(cnt < 0) {
                    valid = false;
                    break;
                }
            }
            if(!valid) continue;
            long long arrangements = factorials[n-1];
            for(int i = 0; i < 10; i++) {
                arrangements /= factorials[new_counts[i]];
            }
            total += arrangements;
        }
        return total;
    }

    long long countGoodIntegers(int n, int k) {
        vector<long long> palindromes = generatePalindromes(n);
        vector<long long> valid_palindromes;
        for(auto num : palindromes) {
            if(num % k == 0) valid_palindromes.push_back(num);
        }

        set<vector<int>> unique_counts;
        for(auto num : valid_palindromes) {
            vector<int> counts = getDigitCounts(num, n);
            unique_counts.insert(counts);
        }

        long long total = 0;
        for(auto counts : unique_counts) {
            total += countNumbers(counts, n);
        }

        return total;
    }
};
