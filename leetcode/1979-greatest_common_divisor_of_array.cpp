class Solution {
public:
    int findGCD(std::vector<int>& nums) {
        int smallest = *std::min_element(nums.begin(), nums.end());
        int highest = *std::max_element(nums.begin(), nums.end());

        return gcd(smallest, highest);
    }

private:
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
};