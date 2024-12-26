class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        
        while(l < a.length && r < b.length){
            if(a[l] <= b[r]){
                res.add(a[l]);
                l++;
            }else{
                res.add(b[r]);
                r++;
            }
        }
        
        while(l < a.length){
            res.add(a[l]);
            l++;
        }
        
        while(r < b.length){
            res.add(b[r]);
            r++;
        }
        return res.get(k - 1);
    }
}