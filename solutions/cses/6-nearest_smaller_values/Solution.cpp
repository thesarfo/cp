#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 2e5 + 1;
int n, arr[MAX_N], nearest_smaller[MAX_N];

int main() {
    scanf("%d", &n);
    
    for (int i = 1; i <= n; i++) {
        scanf("%d", &arr[i]);
        
        int index = i - 1;
        while (arr[index] >= arr[i]) {
            index = nearest_smaller[index];
        }
        
        nearest_smaller[i] = index;
        
        printf("%d%c", nearest_smaller[i], (i == n) ? '\n' : ' ');
    }

    return 0;
}
