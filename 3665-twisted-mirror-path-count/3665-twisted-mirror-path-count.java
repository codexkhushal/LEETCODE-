class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1000000007L;

        int[][][] jump = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r_next_r = i, r_next_c = j + 1;
                if (r_next_c < n && grid[r_next_c == -1 ? 0 : i][r_next_c] == 1) {
                    jump[i][j][0] = -1; 
                } else {
                    jump[i][j][0] = 0; 
                }

                int d_next_r = i + 1, d_next_c = j;
                if (d_next_r < m && grid[d_next_r][d_next_c == -1 ? 0 : j] == 1) {
                    jump[i][j][1] = -1;
                } else {
                    jump[i][j][1] = 0;
                }
            }
        }

        int[][][] nextPos = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cr = i, cc = j + 1;
                int dir = 0; 
                boolean valid = true;
                while (true) {
                    if (cr < 0 || cr >= m || cc < 0 || cc >= n) {
                        valid = false;
                        break;
                    }
                    if (grid[cr][cc] == 1) {
                        if (dir == 0) {
                            dir = 1;
                            cr = cr + 1;
                        } else {
                            dir = 0;
                            cc = cc + 1;
                        }
                    } else {
                        break;
                    }
                }
                if (!valid) {
                    nextPos[i][j][0] = -1;
                } else {
                    nextPos[i][j][0] = cr * 1000 + cc; 
                }

                cr = i + 1;
                cc = j;
                dir = 1; 
                valid = true;
                while (true) {
                    if (cr < 0 || cr >= m || cc < 0 || cc >= n) {
                        valid = false;
                        break;
                    }
                    if (grid[cr][cc] == 1) {
                        if (dir == 0) {
                            dir = 1;
                            cr = cr + 1;
                        } else {
                            dir = 0;
                            cc = cc + 1;
                        }
                    } else {
                        break;
                    }
                }
                if (!valid) {
                    nextPos[i][j][1] = -1;
                } else {
                    nextPos[i][j][1] = cr * 1000 + cc;
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                int targetRight = nextPos[i][j][0];
                if (targetRight != -1) {
                    int tr = targetRight / 1000;
                    int tc = targetRight % 1000;
                    dp[tr][tc] = (dp[tr][tc] + dp[i][j]) % MOD;
                }

                int targetDown = nextPos[i][j][1];
                if (targetDown != -1) {
                    int tr = targetDown / 1000;
                    int tc = targetDown % 1000;
                    dp[tr][tc] = (dp[tr][tc] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}