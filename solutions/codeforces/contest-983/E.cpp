#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define rep(i,a,b) for(int i=a;i<b;i++)
#define all(x) (x).begin(),(x).end()

void solve() {
    int n;
    cin >> n;
    
    vector<ll> a(n);
    rep(i,0,n) cin >> a[i];
    
    vector<ll> ops(n, 0);
    
    ll minVal = *min_element(all(a));
    ll maxVal = *max_element(all(a));
    
    if (maxVal - minVal > 4 * n) {
        cout << "-1\n";
        return;
    }
    
    rep(k,0,n) {
        vector<ll> b = a;
        vector<ll> curr_ops(n, 0);
        
        for(int i = 0; i < n; i++) {
            int left = (i-1+n)%n;
            int right = (i+1)%n;
            
            ll need = max(0LL, maxVal - b[i]);
            
            b[left] -= need;
            b[i] -= 2*need;
            b[right] -= need;
            
            curr_ops[i] += need;
        }
        
        bool balanced = true;
        rep(i,1,n) {
            if (b[i] != b[0]) {
                balanced = false;
                break;
            }
        }
        
        if (balanced) {
            for(ll op : curr_ops) {
                cout << op << " ";
            }
            cout << "\n";
            return;
        }
    }
    
    cout << "-1\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    cin >> t;
    
    while(t--) {
        solve();
    }
    
    return 0;
}