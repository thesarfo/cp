#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& scores) {
        int numOfScores = scores.size();

        vector<pair<int, int>> indexedScores;
        for (int i = 0; i < numOfScores; ++i) {
            indexedScores.push_back(make_pair(scores[i], i));
        }

        sort(indexedScores.begin(), indexedScores.end(),
            [](const pair<int, int>& a, const pair<int, int>& b) { return a.first > b.first; });

        vector<string> ranks(numOfScores);

        vector<string> medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        for (int i = 0; i < numOfScores; ++i) {
            if (i < 3) {
                ranks[indexedScores[i].second] = medals[i];
            } else {
                ranks[indexedScores[i].second] = to_string(i + 1);
            }
        }

        return ranks;
    }
};