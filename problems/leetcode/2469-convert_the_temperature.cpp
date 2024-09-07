class Solution {
public:
    vector<double> convertTemperature(double celsius) {
        double kConv = celsius + 273.15;
        double fConv = celsius * 1.80 + 32.00;

        vector<double> res = {kConv, fConv};
        return res;
    }
};