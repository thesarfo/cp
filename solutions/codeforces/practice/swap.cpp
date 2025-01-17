#include <iostream>
using namespace std;

int swap(int n, int m);

int main(){
    int n, m;
    cin >> n >> m;
    swap(n, m);
    return 0;
}

int swap(int n, int m){
    cout << m << " " << n << endl;
    return 0;
}