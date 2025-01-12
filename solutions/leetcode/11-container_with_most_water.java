class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;

        while(left < right){
            int localArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, localArea);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}