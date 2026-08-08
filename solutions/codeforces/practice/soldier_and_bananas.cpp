#include <bits/stdc++.h>
using namespace std;

int main() {
    int cost;
    int initial;
    int numBananas;
    int totalCost = 0;

    cin >> cost >> initial >> numBananas;

    for(int i = 1; i <= numBananas; i++){
        totalCost += cost * i;
    }
    int amt = totalCost - initial;
    if (amt < 0) {
        amt = 0;
    }
    cout << amt << "\n";
}