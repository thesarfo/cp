class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxp = 0;

        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                maxp = std::max(maxp, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return maxp;
    }
};