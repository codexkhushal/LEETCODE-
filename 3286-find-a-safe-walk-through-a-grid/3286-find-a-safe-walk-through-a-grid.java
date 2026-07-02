import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] minHealthLost = new int[m][n];
        for (int[] row : minHealthLost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        int startCost = grid.get(0).get(0);
        minHealthLost[0][0] = startCost;
        deque.offerFirst(new int[]{0, 0, startCost});
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            int currentLost = curr[2];
            
            if (currentLost > minHealthLost[r][c]) {
                continue;
            }
            
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    int nextLost = currentLost + weight;
                    
                    if (nextLost < minHealthLost[nr][nc]) {
                        minHealthLost[nr][nc] = nextLost;
                        
                        if (weight == 0) {
                            deque.offerFirst(new int[]{nr, nc, nextLost});
                        } else {
                            deque.offerLast(new int[]{nr, nc, nextLost});
                        }
                    }
                }
            }
        }
        
        return health - minHealthLost[m - 1][n - 1] >= 1;
    }
}