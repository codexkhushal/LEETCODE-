import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long totalK = (long) k1 + k2;
        long initialSum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            initialSum += diff[i];
        }

        if (initialSum <= totalK) {
            return 0;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int d : diff) {
            if (d > 0) {
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }

        while (totalK > 0 && !map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            int val = entry.getKey();
            int count = entry.getValue();

            Map.Entry<Integer, Integer> nextEntry = map.firstEntry();
            int nextVal = nextEntry == null ? 0 : nextEntry.getKey();

            long diffSum = (long) (val - nextVal) * count;

            if (totalK >= diffSum) {
                totalK -= diffSum;
                if (nextEntry != null) {
                    map.put(nextVal, map.get(nextVal) + count);
                }
            } else {
                long steps = totalK / count;
                int rem = (int) (totalK % count);
                int newVal = val - (int) steps;

                map.put(newVal, map.getOrDefault(newVal, 0) + count - rem);
                map.put(newVal - 1, map.getOrDefault(newVal - 1, 0) + rem);
                totalK = 0;
            }
        }

        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long val = entry.getKey();
            long count = entry.getValue();
            res += val * val * count;
        }

        return res;
    }
}