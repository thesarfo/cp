#include <bits/stdc++.h>
using namespace std;

int main() {
    int bronzeBefore, bronzeAfter;
    int silverBefore, silverAfter;
    int goldBefore, goldAfter;
    int platinumBefore, platinumAfter;

    cin >> bronzeBefore >> bronzeAfter;
    cin >> silverBefore >> silverAfter;
    cin >> goldBefore >> goldAfter;
    cin >> platinumBefore >> platinumAfter;

    int g2p = platinumAfter - platinumBefore;
    int s2g = goldAfter - goldBefore + g2p;
    int b2s = silverAfter - silverBefore + s2g;

    cout << b2s << '\n';
    cout << s2g << '\n';
    cout << g2p << '\n';
}