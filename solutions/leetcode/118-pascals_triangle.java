class Solution {
    public List<Integer> generateRow(int row) {
        List<Integer> result = new ArrayList<>();
        long element = 1; 
        result.add((int) element); 

        for (int col = 1; col < row; col++) {
            element = element * (row - col) / col; 
            result.add((int) element); 
        }

        return result;
    }

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            pascalTriangle.add(generateRow(i));
        }

        return pascalTriangle;
    }
}