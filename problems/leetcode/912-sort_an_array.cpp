class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSortHelper(nums, 0, nums.size() - 1);
        return nums;
    }

    void mergeSortHelper(vector<int> &nums, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSortHelper(nums, low, mid);
            mergeSortHelper(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    void merge(vector<int> &nums, int l, int m, int r){
        vector<int> left(nums.begin() + l, nums.begin() + m + 1);
        vector<int> right(nums.begin() + m + 1, nums.begin() + r + 1);

        int i = 0, j = 0, k = l;

        while (i < left.size() && j < right.size()) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }
        
        while (i < left.size()) {
            nums[k++] = left[i++];
        }
        
        while (j < right.size()) {
            nums[k++] = right[j++];
        }
    }
};