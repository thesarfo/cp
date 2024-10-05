class Solution {
public:
    int maximumProduct(std::vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        int n = nums.size();
        
        int prod1 = nums[n-1] * nums[n-2] * nums[n-3];
        
        int prod2 = nums[0] * nums[1] * nums[n-1];
        
        return std::max(prod1, prod2);
    }
};