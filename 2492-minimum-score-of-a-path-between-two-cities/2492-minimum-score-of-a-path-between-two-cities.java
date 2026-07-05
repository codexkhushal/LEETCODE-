class Solution {
    private int[] parent;
    
    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        
        for (int[] road : roads) {
            union(road[0], road[1]);
        }
        
        int root1 = find(1);
        int minScore = Integer.MAX_VALUE;
        
        for (int[] road : roads) {
            if (find(road[0]) == root1) {
                minScore = Math.min(minScore, road[2]);
            }
        }
        
        return minScore;
    }
    
    private int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}