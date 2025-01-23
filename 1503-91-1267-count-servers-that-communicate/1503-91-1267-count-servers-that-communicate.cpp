class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<int>indexRowcount(m, 0);
        vector<int>indexColcount(n, 0);

        for (int row = 0;row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    indexColcount[col] += 1;
                    indexRowcount[row] += 1;
                }
            }
        }
        int ConnectedServer = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && (indexColcount[col] > 1 ||
                    indexRowcount[row] > 1)) {
                    ConnectedServer++;
                }
            }
        }
        return ConnectedServer;
    }
};