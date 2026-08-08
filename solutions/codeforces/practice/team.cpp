#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int count = 0;


    for(int i = 0; i < n; i++){
        int a, b, c;
        cin >> a >> b >> c;
        int total = a + b + c;

        if(total >= 2){
            count++;
        }

    }

    cout << count << "\n";
}