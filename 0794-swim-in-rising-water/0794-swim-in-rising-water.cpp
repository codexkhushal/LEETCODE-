class Solution {
public:
    vector<vector<int>> directions{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n;
    bool possToReach(vector<vector<int>>& grid, int i, int j, int t,
                     vector<vector<bool>>& visited) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] == true ||
            grid[i][j] > t) {
            return false;
        }
        visited[i][j] = true;
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        for (auto& dir : directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (possToReach(grid, ii, jj, t, visited)) {
                return true;
            }
        }
        return false;
    }
    int swimInWater(vector<vector<int>>& grid) {

        n = grid.size();
        int l = grid[0][0];
        int r = n * n - 1;

        int result = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            vector<vector<bool>> visited(n, vector<bool>(n, false));
            if (possToReach(grid, 0, 0, mid, visited)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
};