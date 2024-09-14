class Solution {
public:
    int singleNumber(std::vector<int>& nums) {
        std::unordered_map<int, int> frequency_map;

        for (int num : nums) {
            frequency_map[num]++;
        }

        for (const auto& entry : frequency_map) {
            if (entry.second == 1) {
                return entry.first;
            }
        }

        return -1;
    }
};
