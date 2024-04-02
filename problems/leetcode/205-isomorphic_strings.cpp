class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, int> s2i, t2j;
        for (auto& c : s) {
            if (s2i.count(c) != 0) continue;
            s2i[c] = s2i.size();
        }
        for (auto& c : t) {
            if (t2j.count(c) != 0) continue;
            t2j[c] = t2j.size();
        }

        for (int i = 0; i < s.size(); i++) {
            if (s2i[s[i]] != t2j[t[i]]) return false;
        }
        return true;
    }
};