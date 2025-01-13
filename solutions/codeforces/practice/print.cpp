#include <iostream>
using namespace std;

int print(int n);

int main() {
    int n;
    cin >> n;
    print(n);
    return 0;
}

int print(int n) {
    for (int i = 1; i <= n; i++) {
        if (i > 1) {
            cout << " ";
        }
        cout << i;
    }
    cout << endl; 
    return 0;
}
