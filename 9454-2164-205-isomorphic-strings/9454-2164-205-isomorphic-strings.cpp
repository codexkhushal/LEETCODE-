class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char>mp1,mp2;
        if(s.length()!=t.length()){
            return false;
        }
        int n = s.length();
        for(int i = 0 ; i < n;i++){
            int c1 =s[i];
            int c2 =t[i];

            if(mp1.count(c1) && mp1[c1]!= c2){
                return false;
            }
            if(mp2.count(c2) && mp2[c2]!= c1){
                return false;
            }
            mp1[c1]= c2;
            mp2[c2]= c1;
        }
        return true;
    }
};