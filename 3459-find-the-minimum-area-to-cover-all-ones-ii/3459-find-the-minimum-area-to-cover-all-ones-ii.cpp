class Solution {

    int la(int top, int bottom, int right, int left, vector<vector<int>> &sumrow, vector<vector<int>> &sumcol){

        int t  = 0;
        if(top >0) t = sumcol[top-1][left];

        int b = sumcol[bottom][left];
        int index_left = left;
        while(t == b && index_left < right){
            index_left++;
            t = 0;
            if(top >0) t = sumcol[top-1][index_left];
            b = sumcol[bottom][index_left];

        }

        return index_left;

    }

      int ra(int top, int bottom, int right, int left, vector<vector<int>> &sumrow, vector<vector<int>> &sumcol){

        int t  = 0;
        if(top >0) t = sumcol[top-1][right];

        int b = sumcol[bottom][right];
        int index_right = right;
        while(t == b && index_right > left){
            index_right--;
            t = 0;
            if(top >0) t = sumcol[top-1][index_right];
            b = sumcol[bottom][index_right];

        }

        return index_right;

    }

      int ta(int top, int bottom, int right, int left, vector<vector<int>> &sumrow, vector<vector<int>> &sumcol){

        int l  = 0;
        if(left >0) l = sumrow[top][left-1];

        int r = sumrow[top][right];
        int index_top = top;
        while(l == r && index_top < bottom){
            index_top++;
            l = 0;
if(left >0) l = sumrow[index_top][left-1];
            r = sumrow[index_top][right];

        }

        return index_top;

    }

     int ba(int top, int bottom, int right, int left, vector<vector<int>> &sumrow, vector<vector<int>> &sumcol){

        int l  = 0;
        if(left >0) l = sumrow[bottom][left-1];

        int r = sumrow[bottom][right];
        int index_bottom = bottom;
        while(l == r && index_bottom > top){
            index_bottom--;
            l = 0;
if(left >0) l = sumrow[index_bottom][left-1];
            r = sumrow[index_bottom][right];

        }

        return index_bottom;

    }

    int area(int top, int bottom, int right, int left, vector<vector<int>> &sumrow, vector<vector<int>> &sumcol){
        left = la(top,bottom,right,left,sumrow,sumcol);
        right = ra(top,bottom,right,left,sumrow,sumcol);
        top = ta(top,bottom,right,left,sumrow,sumcol);
        bottom = ba(top,bottom,right,left,sumrow,sumcol);

        return (right-left+1)*(bottom-top+1);
      
    }


    
public:
    public:
    int minimumSum(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();

        vector<vector<int>> sumrow(n, vector<int>(m, 0));
        vector<vector<int>> sumcol(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            sumrow[i][0] = grid[i][0];
            for (int j = 1; j < m; j++) {
                sumrow[i][j] = sumrow[i][j-1] + grid[i][j];
            }
        }
        for (int j = 0; j < m; j++) {
            sumcol[0][j] = grid[0][j];
            for (int i = 1; i < n; i++) {
                sumcol[i][j] = sumcol[i-1][j] + grid[i][j];
            }
        }

        int ans = INT_MAX;

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int a = area(0, i, m-1, 0, sumrow, sumcol);
                int b = area(i+1, j, m-1, 0, sumrow, sumcol);
                int c = area(j+1, n-1, m-1, 0, sumrow, sumcol);
                ans = min(ans, a + b + c);
            }
        }

        for (int i = 0; i < m-2; i++) {
            for (int j = i+1; j < m-1; j++) {
                int a = area(0, n-1, i, 0, sumrow, sumcol);
                int b = area(0, n-1, j, i+1, sumrow, sumcol);
                int c = area(0, n-1, m-1, j+1, sumrow, sumcol);
                ans = min(ans, a + b + c);
            }
        }

        for (int cut = 0; cut < n-1; cut++) {
            for (int vcut = 0; vcut < m-1; vcut++) {
                int a = area(0, cut, m-1, 0, sumrow, sumcol);
                int b = area(cut+1, n-1, vcut, 0, sumrow, sumcol);
                int c = area(cut+1, n-1, m-1, vcut+1, sumrow, sumcol);
                ans = min(ans, a + b + c);

                a = area(n-1-cut, n-1, m-1, 0, sumrow, sumcol);
                b = area(0, n-2-cut, vcut, 0, sumrow, sumcol);
                c = area(0, n-2-cut, m-1, vcut+1, sumrow, sumcol);
                ans = min(ans, a + b + c);
            }
        }

        for (int cut = 0; cut < m-1; cut++) {
            for (int hcut = 0; hcut < n-1; hcut++) {
                int a = area(0, n-1, cut, 0, sumrow, sumcol);
                int b = area(0, hcut, m-1, cut+1, sumrow, sumcol);
                int c = area(hcut+1, n-1, m-1, cut+1, sumrow, sumcol);
                ans = min(ans, a + b + c);

                a = area(0, n-1, m-1, cut+1, sumrow, sumcol);
                b = area(0, hcut, cut, 0, sumrow, sumcol);
                c = area(hcut+1, n-1, cut, 0, sumrow, sumcol);
                ans = min(ans, a + b + c);
            }
        }

        return ans;
    }

};