class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> cmpn = new ArrayList<>();
        int pwt = 1;
        int tmpn = n;

        while(tmpn > 0){
            int digit = tmpn % 10;

            if(digit != 0){
                int cmpnt = digit * pwt;
                cmpn.add(cmpnt);
            }
            tmpn /= 10;
            pwt *= 10;
        }

        Collections.reverse(cmpn);
        int[] res = new int[cmpn.size()];
        for(int i = 0; i < cmpn.size(); i++){
            res[i] = cmpn.get(i);
        }
        return res;
    }
}