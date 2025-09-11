class Solution {
public:
    string sortVowels(string s) {

        vector<int>freq(128, 0);
        vector<bool>isVowels(128, false);

        string vowels = "aeiouAEIOU";
        for(char v : vowels){
            isVowels[v] = true;
        }
        for(char c : s){
            if(isVowels[c]){
                freq[c]++;
            }
        }
  
        string order = "AEIOUaeiou";
        int pos = 0;
        for(char &c : s){
            if(isVowels[c]){
                while(pos < order.size() && freq[order[pos]] == 0){
                    pos++;
                }
                c = order[pos];
                freq[order[pos]]--;
            }
        }
       
        return s;
    }
};