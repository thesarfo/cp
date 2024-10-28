#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

// Function to merge two sorted vector of pairs, keeping maximum subset size for each idx value
vector<pair<int, int>> merge_unique(const vector<pair<int, int>> &fp, const vector<pair<int, int>> &sp) {
    vector<pair<int, int>> merged;
    merged.reserve(fp.size() + sp.size());

    int i = 0, j = 0;
    int n = fp.size(), m = sp.size();

    while (i < n && j < m) {
        if (fp[i].first == sp[j].first) {
            merged.emplace_back(fp[i].first, max(fp[i].second, sp[j].second));
            i++;
            j++;
        } else if (fp[i].first < sp[j].first) {
            merged.emplace_back(fp[i]);
            i++;
        } else {
            merged.emplace_back(sp[j]);
            j++;
        }
    }

    while (i < n) {
        merged.emplace_back(fp[i]);
        i++;
    }

    while (j < m) {
        merged.emplace_back(sp[j]);
        j++;
    }

    // Remove duplicates, keeping maximum subset size
    vector<pair<int, int>> final_dp;
    for (auto& p : merged) {
        if (!final_dp.empty() && final_dp.back().first == p.first) {
            final_dp.back().second = max(final_dp.back().second, p.second);
        } else {
            final_dp.emplace_back(p.first, p.second);
        }
    }

    return final_dp;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> a(n), b(k);
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < k; i++) cin >> b[i];

    vector<int> dp(k);
    dp[0] = b[0];

    for (int i = 1; i < k; i++) {
        dp[i] = dp[i - 1] + b[i];
    }

    // Initialize DP with zero-sum dp
    vector<vector<pair<int, int>>> dp_zero;
    dp_zero.push_back({{0, 0}});
    for (int i = 0; i < n; i++) {
        vector<pair<int, int>> new_dp;
        for (auto& sub : dp_zero) {
            for (auto& [idx, sum] : sub) {
                new_dp.emplace_back(idx + 1, sum + a[i]);
            }
        }
        dp_zero.push_back(move(new_dp));
    }

    // Sort each DP value
    sort(dp_zero[k - 1].begin(), dp_zero[k - 1].end(), [](const pair<int, int> &p1, const pair<int, int> &p2) -> bool {
        return p1.first < p2.first;
    });

    // Remove duplicates, keeping maximum sum
    vector<pair<int, int>> tmp_unique;
    for (auto& sub : dp_zero[k - 1]) {
        if (!tmp_unique.empty() && tmp_unique.back().first == sub.first) {
            tmp_unique.back().second = max(tmp_unique.back().second, sub.second);
        } else {
            tmp_unique.emplace_back(sub.first, sub.second);
        }
    }

    // Merge dp and tmp_unique
    dp = merge_unique(dp, tmp_unique);

    // Find the maximum value
    int max_val = 0; // Considering the case of selecting only zeros
    for (auto& dp_el : dp) {
        if (dp_el.first == k) {
            max_val = max(max_val, dp_el.second);
        }
    }

    cout << max_val << "\n";
}

