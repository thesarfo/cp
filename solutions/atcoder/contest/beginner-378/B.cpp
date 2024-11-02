#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    vector<int> q(N), r(N);
    for (int i = 0; i < N; ++i) {
        cin >> q[i] >> r[i];
    }
    
    int Q;
    cin >> Q;
    
    for (int j = 0; j < Q; ++j) {
        int t, d;
        cin >> t >> d;
        --t;  
        
        int qi = q[t], ri = r[t];
        
        if (d % qi == ri) {
            cout << d << endl;  
        } else {
            int next_day = d + ((ri - d % qi + qi) % qi);
            cout << next_day << endl;
        }
    }
    
    return 0;
}
