#include <bits/stdc++.h>
using namespace std;
#define ll long long int

int main(){
    int t;
    cin >> t;
    while(t--){
        ll n, k;
        cin >> n >> k;
        ll mx_x = min(k - 1, n - k);
        bool f = false;
        vector<ll> pos;
        ll m = 0;
        for(ll x = 1; x <= mx_x; x++){
            ll tmp = k - 1 - x;
            if(tmp < 0){
                continue;
            }
            ll tv;
            if(tmp % 2 == 0){
                tv = 0;
            }
            else{
                tv = 1;
            }
            ll mn_p = min(k - 1 - x, n - k - x);
            if(tv > mn_p){
                continue;
            }
            ll cm = 1 + 2 * x;
            ll l = k - tv - 1;
            ll r = n - k - tv;
            if(l < x || r < x){
                continue;
            }
            
            vector<ll> pos_lst;
            ll p = 1;
            for(ll i = 1; i <= x - 1; i++){
                pos_lst.push_back(p);
                p += 1;
            }
            if(x > 0){
                pos_lst.push_back(p);
                p += (l - (x - 1));
            }
            pos_lst.push_back(p);
            p += (2 * tv + 1);
            for(ll i = 1; i <= x - 1; i++){
                pos_lst.push_back(p);
                p += 1;
            }
            if(x > 0){
                pos_lst.push_back(p);
                p += (r - (x - 1));
            }
            if(p - 1 == n){
                m = cm;
                pos = pos_lst;
                f = true;
                break;
            }
        }
        if(f){
            cout << m << "\n";
            for(ll i = 0; i < pos.size(); i++){
                cout << pos[i] << (i < pos.size() - 1 ? ' ' : '\n');
            }
            continue;
        }
        ll t0 = (n - 1) / 2;
        if(t0 == k - 1){
            cout << "1\n1\n";
            continue;
        }
        cout << "-1\n";
    }
}