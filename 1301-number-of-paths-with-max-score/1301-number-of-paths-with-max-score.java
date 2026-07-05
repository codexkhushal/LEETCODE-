import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        int[][] maxScore = new int[n][n];
        int[][] pathCount = new int[n][n];

        pathCount[n - 1][n - 1] = 1;

        int[] dr = {0, 1, 1};
        int[] dc = {1, 0, 1};

        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (pathCount[r][c] == 0 || board.get(r).charAt(c) == 'X') {
                    continue;
                }

                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i] * -1;
                    int nc = c + dc[i] * -1;

                    if (nr >= 0 && nc >= 0 && board.get(nr).charAt(nc) != 'X') {
                        char nextChar = board.get(nr).charAt(nc);
                        int val = (nextChar == 'E') ? 0 : (nextChar - '0');
                        int nextScore = maxScore[r][c] + val;

                        if (nextScore > maxScore[nr][nc]) {
                            maxScore[nr][nc] = nextScore;
                            pathCount[nr][nc] = pathCount[r][c];
                        } else if (nextScore == maxScore[nr][nc]) {
                            pathCount[nr][nc] = (pathCount[nr][nc] + pathCount[r][c]) % MOD;
                        }
                    }
                }
            }
        }

        return new int[]{maxScore[0][0], pathCount[0][0]};
    }
}