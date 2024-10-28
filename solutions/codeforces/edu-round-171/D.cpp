#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    vector<int> a(n + 1, 0);
    for (int i = 1; i <= n; ++i) cin >> a[i];
    
    // Compute prefix and prefix_weight
    vector<ll> prefix(n + 1, 0);
    vector<ll> prefix_weight(n + 1, 0);
    for (int i = 1; i <= n; ++i) {
        prefix[i] = prefix[i - 1] + a[i];
        prefix_weight[i] = prefix_weight[i - 1] + (ll)i * a[i];
    }
    
    // Compute sum_prefix and sum_prefix_weight
    vector<ll> sum_prefix(n + 1, 0);
    vector<ll> sum_prefix_weight(n + 1, 0);
    for (int i = 1; i <= n; ++i) {
        sum_prefix[i] = sum_prefix[i - 1] + prefix[i];
        sum_prefix_weight[i] = sum_prefix_weight[i - 1] + prefix_weight[i];
    }
    
    // Compute sum_blocks
    vector<ll> sum_blocks(n + 1, 0); // sum_blocks[1..n]
    for (int i = 1; i <= n; ++i) {
        sum_blocks[i] = (ll)i * n - ((ll)i * (i - 1)) / 2;
    }
    
    // Compute C
    ll C = (ll)(n + 1) * prefix[n] - prefix_weight[n];
    
    // Function to compute sum_b(k)
    auto get_sum_b = [&](ll k) -> ll {
        if (k == 0) return 0;
        
        // Binary search to find l
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum_blocks[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        int l = left;
        ll sum_blocks_lm1 = (l > 1) ? sum_blocks[l - 1] : 0;
        ll p = k - sum_blocks_lm1;
        
        // Compute the sum
        ll term1 = (ll)(l) * C;
        ll term2 = (ll)(n + 1) * ((l - 2) >= 0 ? ((l - 2) >= 1 ? sum_prefix[l - 2] : 0) : 0);
        ll term3 = (l - 2) >= 0 ? ((l - 2) >= 1 ? sum_prefix_weight[l - 2] : 0) : 0;
        
        // Handle sum_prefix and sum_prefix_weight for l-2
        ll sum_prefix_lm2 = 0;
        if (l > 2) {
            sum_prefix_lm2 = sum_prefix[l - 2];
        }
        
        ll sum_prefix_weight_lm2 = 0;
        if (l >= 2) {
            sum_prefix_weight_lm2 = sum_prefix_weight[l - 2];
        }
        
        term2 -= (ll)(n + 1) * sum_prefix_lm2;
        term3 = sum_prefix_weight_lm2;
        
        // Compute (p + l)*(prefix[l+p-1] - prefix[l-1]) - (prefix_weight[l+p-1] - prefix_weight[l-1])
        ll prefix_sum = prefix[l + p - 1] - prefix[l - 1];
        ll prefix_weight_sum = prefix_weight[l + p - 1] - prefix_weight[l - 1];
        ll term4 = (p + (ll)l) * prefix_sum;
        ll term5 = prefix_weight_sum;

        return ((ll)(l - 1) * C - (ll)(n + 1) * sum_prefix_lm2 + sum_prefix_weight_lm2) + (term4 - term5);
    };
    
    // Read queries
    int q;
    cin >> q;
    while (q--) {
        ll li, ri;
        cin >> li >> ri;
        ll sum_ri = get_sum_b(ri);
        ll sum_li_1 = get_sum_b(li - 1);
        cout << (sum_ri - sum_li_1) << "\n";
    }

    return 0;
}
