class Solution {
    public int[] minBitwiseArray(List<Integer> values) {
        int size = values.size();
        int[] result = new int[size];
        
        for (int index = 0; index < size; index++) {
            int currentValue = values.get(index);
            int smallestValidValue = Integer.MAX_VALUE;
            boolean isValidValueFound = false;
            
            for (int shift = 0; shift <= 30; shift++) {
                if (((currentValue >> shift) & 1) == 1) {
                    int modifiedValue = currentValue & ~(1 << shift);
                    
                    if (modifiedValue < 0) continue; 
                    

                    if ((modifiedValue | (modifiedValue + 1)) == currentValue) {
                        if (modifiedValue < smallestValidValue) {
                            smallestValidValue = modifiedValue;
                            isValidValueFound = true;
                        }
                    }
                }
            }
            
            if (isValidValueFound) {
                result[index] = smallestValidValue;
            } else {
                result[index] = -1;
            }
        }
        
        return result;
    }
}
