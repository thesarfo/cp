#include <bits/stdc++.h>
using namespace std;

int main() {
    int a, b, x, y;
    cin >> a >> b >> x >> y;

    int normal = abs(a - b);
    int teleport1 = abs(a - x) + abs(y - b);
    int teleport2 = abs(a - y) + abs(x - b);

    cout << min({normal, teleport1, teleport2}) << "\n";
}