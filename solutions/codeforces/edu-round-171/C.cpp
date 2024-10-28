#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
#define all(x) x.begin(),x.end()
#define pb push_back

void solve() {
    int n;
    cin >> n;
    string s;
    cin >> s;

    vector<int> prevzeros(0);
    vector<int> prevones(0);
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == '0')
            prevzeros.pb(i);
        else
            prevones.pb(i);
    }
    reverse(all(prevones));
    int pzi = prevzeros.size() -1;
    int poi = prevones.size() -1;

    long long total = (long long)n * (n + 1) / 2;

    for (int i = n - 1; i >= 0; i--) {
        while (pzi >= 0 && prevzeros[pzi] >= i)
            pzi--;
        while (poi >= 0 && prevones[poi] >= i)
            poi--;
        if (s[i] == '1') {
            if (pzi >= 0) {
                total -= (long long) i + 1;
                pzi--;
            } else if (poi >= 0) {
                total -= (long long) i + 1;
                poi--;
            }
        }
    }
    cout << total << endl;
}

int main() {
    int t;
    cin >> t;
    while (t--)
        solve();
}

