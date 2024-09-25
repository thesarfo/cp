class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int pme;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(count == 0){
                count = 1;
                pme = nums[i];
            } else if(nums[i] == pme){
                count++;
            } else{
                count--;
            }
        }

        int vCount = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == pme){
                vCount++;
            }
        }

        if(vCount > (n / 2)) return pme;

        return -1;

    }
};