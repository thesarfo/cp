class Solution {
public:
    vector<int> getOccurrences(const string &txt, const string &pat) {
        vector<int> occ;
        if (pat.empty())return occ;
        int n=txt.size(),m=pat.size();
        vector<int> temp(m, 0);

        for (int i=1,len=0;i<m;){
            if (pat[i]==pat[len]){
                temp[i++]=++len;
            } else {
                if (len!=0){
                    len=temp[len-1];
                } else{
                    temp[i++]=0;
                }
            }
        }

        for (int i=0,j=0;i<n;i++){
            while (j>0&&txt[i]!=pat[j]){
                j=temp[j-1];
            }
            if (txt[i]==pat[j]){
                j++;
            }
            if (j==m){
                occ.push_back(i - m + 1);
                j=temp[j-1];
            }
        }
        return occ;
    }

    int shortestMatchingSubstring(const string &s, const string &p) {
        int firstStar = p.find('*');
        int secondStar = p.find('*', firstStar + 1);
        string A = p.substr(0, firstStar);
        string B = p.substr(firstStar+1,secondStar-firstStar- 1);
        string C = p.substr(secondStar+1);
        int a = A.size(),b= B.size(),c=C.size();

        if (a==0&&b==0&&c==0)return 0;

        vector<int>occA=(a>0)?getOccurrences(s, A) : vector<int>();
        vector<int>occB=(b>0)?getOccurrences(s, B) : vector<int>();
        vector<int>occC=(c>0)?getOccurrences(s, C) : vector<int>();

        int ans=INT_MAX;

        if (b >0){
            for (int m_index:occB) {
                int i_candidate;
                if (a > 0) {
                    auto it = upper_bound(occA.begin(), occA.end(), m_index - a);
                    if (it == occA.begin()) continue;
                    --it;
                    i_candidate = *it;
                } else {
                    i_candidate = m_index;
                }

                if (c>0) {
                    auto it2=lower_bound(occC.begin(), occC.end(), m_index + b);
                    if (it2==occC.end()) continue;
                    int n_candidate=*it2;
                    int candidate=(n_candidate+c)-i_candidate;
                    ans = min(ans,candidate);
                } else {
                    int candidate=(m_index+b)-i_candidate;
                    ans=min(ans, candidate);
                }
            }
        } else {
            if (a>0 &&c>0) {
                for (int i_val : occA) {
                    auto it=lower_bound(occC.begin(), occC.end(), i_val + a);
                    if (it == occC.end())continue;
                    int n_candidate=*it;
                    int candidate=(n_candidate+c)-i_val;
                    ans=min(ans,candidate);
                }
            } else if(a>0&&c==0) {
                if (!occA.empty()){
                    ans=min(ans,a);
                }
            } else if(a==0&&c>0){
                if (!occC.empty()){
                    ans=min(ans,c);
                }
            }
        }

        return (ans ==INT_MAX?-1:ans);
    }
};
