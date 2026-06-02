class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        
        int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }
        
        int minWaterEnd = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[j] + waterDuration[j]);
        }
        
        int minTotalFinishTime = Integer.MAX_VALUE;
        
       
        for (int j = 0; j < m; j++) {
            int startWaterTime = Math.max(minLandEnd, waterStartTime[j]);
            minTotalFinishTime = Math.min(minTotalFinishTime, startWaterTime + waterDuration[j]);
        }
        
        for (int i = 0; i < n; i++) {
            int startLandTime = Math.max(minWaterEnd, landStartTime[i]);
            minTotalFinishTime = Math.min(minTotalFinishTime, startLandTime + landDuration[i]);
        }
        
        return minTotalFinishTime;
    }
}