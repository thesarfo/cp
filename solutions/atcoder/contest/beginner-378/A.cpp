#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    int a1, a2, a3, a4;
    cin >> a1 >> a2 >> a3 >> a4;

    unordered_map<int, int> colorCount;
    colorCount[a1]++;
    colorCount[a2]++;
    colorCount[a3]++;
    colorCount[a4]++;

    int maxPairs = 0;
    for (auto &entry : colorCount) {
        maxPairs += entry.second / 2;
    }

    cout << maxPairs << endl;
    return 0;
}
