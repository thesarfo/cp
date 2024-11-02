#include <bits/stdc++.h>
using namespace std;

void checkForSubstring1100(set<int>& indices, const string& s, int pos) {
    if (pos >= 0 && pos + 3 < s.size() && s.substr(pos, 4) == "1100") {
        indices.insert(pos);
    } else {
        indices.erase(pos);
    }
}

void solve() {
    int t;
    cin >> t;
    
    while (t--) {
        string s;
        cin >> s;
        int q;
        cin >> q;

        set<int> indices;
        for (int i = 0; i <= s.size() - 4; ++i) {
            if (s.substr(i, 4) == "1100") {
                indices.insert(i);
            }
        }

        while (q--) {
            int i, v;
            cin >> i >> v;
            --i;

            s[i] = v + '0';
            for (int j = max(0, i - 3); j <= min((int)s.size() - 4, i); ++j) {
                checkForSubstring1100(indices, s, j);
            }

            cout << (indices.empty() ? "NO" : "YES") << "\n";
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
    return 0;
}