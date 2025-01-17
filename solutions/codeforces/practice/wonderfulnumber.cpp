#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool isPalindromeBinary(int n) {
    string binary = "";
    while (n > 0) {
        binary += (n % 2 == 0 ? '0' : '1');
        n /= 2;
    }
    string reversedBinary = binary;
    reverse(reversedBinary.begin(), reversedBinary.end());
    return binary == reversedBinary;
}

bool isOdd(int n) {
    return n % 2 == 1;
}

int main() {
    int n;
    cin >> n;

    if (isOdd(n) && isPalindromeBinary(n)) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }

    return 0;
}
