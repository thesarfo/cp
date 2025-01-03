class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max = -1, index = -1;
        
        for(int i = 0; i < arr.length; i++){
            int countOnes = 0;
            for(int j = 0; j < arr[i].length; j++){
                countOnes += arr[i][j];
            }
            if(countOnes > max){
                max = countOnes;
                index = i;
            }
        }
        return index;
    }
}