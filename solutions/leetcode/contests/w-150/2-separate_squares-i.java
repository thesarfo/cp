class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }
        
        while (high - low > 1e-5) {
            double mid = low + (high - low) / 2;
            double areaAbove = calculateAreaAbove(squares, mid);
            double areaBelow = calculateAreaBelow(squares, mid);
            
            if (areaAbove > areaBelow) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private double calculateAreaAbove(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            double yi = square[1];
            double li = square[2];
            double top = yi + li;
            if (top > y) {
                double overlap = Math.min(top, y + li) - y;
                area += overlap * li;
            }
        }
        return area;
    }
    
    private double calculateAreaBelow(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            double yi = square[1];
            double li = square[2];
            double bottom = yi;
            if (bottom < y) {
                double overlap = y - Math.max(bottom, y - li);
                area += overlap * li;
            }
        }
        return area;
    }
}
