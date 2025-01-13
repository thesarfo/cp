#include <iostream>
using namespace std;
 
int add(int a, int b);
 
int main() {
    int a;
    int b;
    
    cin >> a >> b;
    
    add(a, b);
 
    return 0;
}
 
int add(int a, int b){
    cout << (a + b) << endl;
    return a + b; 
}