class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string , vector<string>> group ;
        for(string& words : strs) {
            string key  = words;
            sort(key.begin(), key.end());
            group[key].push_back(words);

        }
        vector<vector<string>> results;
        for(auto &entry: group){
            results.push_back(entry.second);
        }
        return results;
    }
};