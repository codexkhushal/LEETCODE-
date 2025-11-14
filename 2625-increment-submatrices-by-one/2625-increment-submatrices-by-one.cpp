class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>>mat(n , vector<int>(n ,0));
        for(auto it : queries){
            int r1 = it[0];
            int c1 = it[1];
            int r2 = it[2];
            int c2 = it[3];

         for(int i=r1 ; i<=r2 ; i++){
            mat[i][c1]++ ;
            if(c2+1 < n){
                mat[i][c2+1]-- ;
            }
          }
        }

        for(int i=0 ; i<mat.size(); i++){
            for(int j=1 ; j<mat[0].size(); j++){
                mat[i][j] +=mat[i][j-1];
            }
        }

        return mat ;
    }
};