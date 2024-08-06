class Solution {

    void printSquare(int n) {
        // code here
        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++){
                System.out.print("* ");
            }
            System.out.print("*\n");
        }
    }
}