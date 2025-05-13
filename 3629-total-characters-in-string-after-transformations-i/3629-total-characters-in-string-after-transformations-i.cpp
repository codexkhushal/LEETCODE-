class Solution {
public:
    int m = 1e9+7;
    int lengthAfterTransformations(string s, int t) {
        int n = s.length();
        //unordered_map<char,int>mp;
        vector<int>mp(26,0);
        for(char &ch : s){
            mp[ch  -'a']++;
        }

        for(int count = 1; count <= t;count++){
            //unordered_map<char,int> temp; 
            vector<int>temp(26, 0); 
            for(int i = 0 ; i < 26;i++){
                char ch = i +'a';
                int freq = mp[i];

                if(ch!='z'){
                    temp[(ch+1) - 'a'] = (temp[(ch+1) - 'a'] + freq)%m;
                }else{  
                    temp['a'-'a'] = (temp['a'-'a'] + freq)%m;
                    temp['b'-'a'] = (temp['b'-'a'] + freq)%m;
                }
            }
            mp = move(temp);
        }
        int result = 0 ;
        for(int i = 0 ; i < 26 ; i++ ){
            result = (result + mp[i]) %m;
        }
        return result ;
    }
};