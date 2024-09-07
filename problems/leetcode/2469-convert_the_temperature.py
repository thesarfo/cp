class Solution(object):
    def convertTemperature(self, celsius):
        """
        :type celsius: float
        :rtype: List[float]
        """
        kConv = celsius + 273.15
        fConv = celsius * 1.80 + 32.00

        return [kConv, fConv]
        