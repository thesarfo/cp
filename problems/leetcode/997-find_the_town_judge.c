#include <stdlib.h>

int findJudge(int n, int** trust, int trustSize, int* trustColSize) {
    int* trustCount = (int*)calloc(n + 1, sizeof(int)); 
    int* trustedByCount = (int*)calloc(n + 1, sizeof(int)); 
    
    for (int i = 0; i < trustSize; i++) {
        int a = trust[i][0];
        int b = trust[i][1];
        trustCount[b]++;
        trustedByCount[a]++;
    }
    
    for (int i = 1; i <= n; i++) {
        if (trustCount[i] == n - 1 && trustedByCount[i] == 0) {
            free(trustCount);
            free(trustedByCount);
            return i; 
        }
    }
    
    free(trustCount);
    free(trustedByCount);
    return -1; 
}