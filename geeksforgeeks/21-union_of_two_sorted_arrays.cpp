class Solution{
    public:
    //arr1,arr2 : the arrays
    // n, m: size of arrays
    //Function to return a list containing the union of the two arrays. 
    vector<int> findUnion(int arr1[], int arr2[], int n, int m)
    {
        //Your code here
        set<int> s;
        
        for(int i = 0; i < n; i++){
            s.insert(arr1[i]);
        }
        
        for(int i = 0; i < m; i++){
            s.insert(arr2[i]);
        }
        
        vector<int> unionRes;
        
        for(auto it : s){
            unionRes.push_back(it);
        }
        //return vector with correct order of elements
        return unionRes;
    }
};