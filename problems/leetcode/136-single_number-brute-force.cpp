class Solution {
public:
    int singleNumber(vector<int>& nums) {
        for(int i = 0; i < nums.size(); i++){
            int num = nums[i];
            int count = 0;

            for(int j = 0; j < nums.size(); j++){
                if(nums[j] == num){
                    count++;
                }
            }
            if(count == 1) return num;
        }
        return -1;
    }
};