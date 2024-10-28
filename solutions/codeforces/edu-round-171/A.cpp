#include <bits/stdc++.h>
using namespace std;

#define int long long
#define pb push_back
const int M = 1e9 + 7;
const int N = 2e5 + 5;

signed main() {
    int t; 
    cin >> t;
    
    while (t--) {
        int a, b, k; 
        cin >> a >> b >> k;
        int val = min(a, b);
        cout << "0 " << val << " " << val << " 0" << endl;
        cout << "0 0 " << val << " " << val << endl;
    }
}

