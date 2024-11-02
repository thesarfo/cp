#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> A(N);
    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }
    
    vector<int> B(N, -1);  
    unordered_map<int, int> last_seen;  

    for (int i = 0; i < N; ++i) {
        if (last_seen.find(A[i]) != last_seen.end()) {
            B[i] = last_seen[A[i]] + 1;  
        }
        last_seen[A[i]] = i;  
    }
    

    for (int i = 0; i < N; ++i) {
        cout << B[i] << " ";
    }
    cout << endl;

    return 0;
}
