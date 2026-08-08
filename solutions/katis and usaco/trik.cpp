#include <bits/stdc++.h>
using namespace std;

int main() {
    string s;
    cin >> s;

    int pos = 0;

    for (char move : s) {
        if (move == 'A') {
            if (pos == 0) pos = 1;
            else if (pos == 1) pos = 0;
        }
        else if (move == 'B') {
            if (pos == 1) pos = 2;
            else if (pos == 2) pos = 1;
        }
        else if (move == 'C') {
            if (pos == 0) pos = 2;
            else if (pos == 2) pos = 0;
        }
    }

    cout << pos + 1 << '\n';
}