class Solution {
public:
    int countPairs(vector<int>& nums, int k) {
        int n = nums.size();
        int result = 0 ;

        unordered_map<int,vector<int>>indices;
        for(int i = 0 ; i< n; i ++){
            indices[nums[i]].push_back(i);
        }

        unordered_set<int> div;
        for(int f =1 ; f*f <= (k) ;f++){
            if(k%f == 0){
                div.insert(f);
                div.insert(k/f);
            }
        }

        for(auto & [num , indice]: indices){
            unordered_map<int ,int> factors;
            for(int i : indice){
            int GCD = gcd(i,k);
            int j = k/GCD;

            result+= factors[j];

            for(int f : div){
                if(i%f ==0){
                    factors[f]++;
                }
            }
            }
        }
        return result;
    }
};