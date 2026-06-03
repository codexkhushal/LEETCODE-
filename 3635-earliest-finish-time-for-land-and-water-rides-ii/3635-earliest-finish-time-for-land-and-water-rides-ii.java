class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        long landFirstBest = getEarliestFinish(landStartTime, landDuration, waterStartTime, waterDuration);
        
        long waterFirstBest = getEarliestFinish(waterStartTime, waterDuration, landStartTime, landDuration);
        
        return (int) Math.min(landFirstBest, waterFirstBest);
    }
    
    private long getEarliestFinish(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int n = firstStart.length;
        int m = secondStart.length;
        
        long minFirstFinish = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long finishTime = (long) firstStart[i] + firstDuration[i];
            if (finishTime < minFirstFinish) {
                minFirstFinish = finishTime;
            }
        }
        
        long minGlobalFinish = Long.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            long actualStart = Math.max(minFirstFinish, (long) secondStart[j]);
            long totalFinish = actualStart + secondDuration[j];
            if (totalFinish < minGlobalFinish) {
                minGlobalFinish = totalFinish;
            }
        }
        
        return minGlobalFinish;
    }
}