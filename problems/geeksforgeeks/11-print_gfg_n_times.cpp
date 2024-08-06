class Solution {
  public:
    void printGfg(int N) {
        // Code here
        if (N < 1) return;
        printGfg(N - 1);
        cout << "GFG ";
    }
};