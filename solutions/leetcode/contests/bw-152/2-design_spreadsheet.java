class Spreadsheet {
    private int[][] grid;
    private int rows;
    
    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] coordinates = parseCellReference(cell);
        grid[coordinates[0]][coordinates[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] coordinates = parseCellReference(cell);
        grid[coordinates[0]][coordinates[1]] = 0;
    }
    
    public int getValue(String formula) {
        if (formula.startsWith("=")) {
            String[] parts = formula.substring(1).split("\\+");
            int x = parseOperand(parts[0]);
            int y = parseOperand(parts[1]);
            return x + y;
        }
        return 0;
    }
    
    private int parseOperand(String operand) {
        if (operand.length() > 0 && Character.isLetter(operand.charAt(0))) {
            int[] coordinates = parseCellReference(operand);
            return grid[coordinates[0]][coordinates[1]];
        } else {
            return Integer.parseInt(operand);
        }
    }
    
    private int[] parseCellReference(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
