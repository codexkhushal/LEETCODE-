class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& list) {
        unordered_map<string , vector<string>> group ;
        for(string& words : list) {
            string key  = words;
            sort(key.begin(), key.end());
            group[key].push_back(words);

        }
        vector<vector<string>> results;
        for(auto &pair: group){
            results.push_back(pair.second);
        }
        return results;
    }
};