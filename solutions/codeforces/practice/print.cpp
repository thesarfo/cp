#include <iostream>
using namespace std;

int print(int n);

int main() {
    int n;
    cin >> n;
    print(n);
    return 0;
}

int print(int n){
    for(int i = 1; i <= n; i++){
        cout << i << endl;
    }
    return 0; 
}
