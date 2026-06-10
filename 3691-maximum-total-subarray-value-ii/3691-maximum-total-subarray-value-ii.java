import java.util.PriorityQueue;

class Solution {
    private static class Element {
        long value;
        int l;
        int r;

        Element(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    private int[][] stMax;
    private int[][] stMin;
    private int[] logTable;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        int maxLog = logTable[n] + 1;
        stMax = new int[n][maxLog];
        stMin = new int[n][maxLog];

        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }

        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }

        PriorityQueue<Element> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));

        for (int l = 0; l < n; l++) {
            long val = queryValue(l, n - 1);
            maxHeap.offer(new Element(val, l, n - 1));
        }

        long totalValue = 0;

        for (int step = 0; step < k; step++) {
            if (maxHeap.isEmpty()) break;

            Element curr = maxHeap.poll();
            totalValue += curr.value;

            if (curr.r > curr.l) {
                int nextR = curr.r - 1;
                long nextVal = queryValue(curr.l, nextR);
                maxHeap.offer(new Element(nextVal, curr.l, nextR));
            }
        }

        return totalValue;
    }

    private long queryValue(int l, int r) {
        int len = r - l + 1;
        int k = logTable[len];
        
        int maxVal = Math.max(stMax[l][k], stMax[r - (1 << k) + 1][k]);
        int minVal = Math.min(stMin[l][k], stMin[r - (1 << k) + 1][k]);
        
        return (long) maxVal - minVal;
    }
}