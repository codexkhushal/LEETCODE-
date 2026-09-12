import java.util.*;

class Solution {
    private static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.r, b.r));

        int[] prevNonOverlap = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1, ans = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (arr[mid].r < arr[i].l) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prevNonOverlap[i] = ans;
        }

        long[][] dpWeight = new long[n + 1][5];
        List<Integer>[][] dpIndices = new List[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dpIndices[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            Interval curr = arr[i - 1];
            int p = prevNonOverlap[i - 1];

            for (int k = 1; k <= 4; k++) {
                long skipW = dpWeight[i - 1][k];
                List<Integer> skipIdx = dpIndices[i - 1][k];

                long takeW = dpWeight[p + 1][k - 1] + curr.weight;
                List<Integer> takeIdx = new ArrayList<>(dpIndices[p + 1][k - 1]);
                takeIdx.add(curr.id);
                Collections.sort(takeIdx);

                if (takeW > skipW) {
                    dpWeight[i][k] = takeW;
                    dpIndices[i][k] = takeIdx;
                } else if (skipW > takeW) {
                    dpWeight[i][k] = skipW;
                    dpIndices[i][k] = skipIdx;
                } else {
                    dpWeight[i][k] = skipW;
                    if (compareIndices(takeIdx, skipIdx) < 0) {
                        dpIndices[i][k] = takeIdx;
                    } else {
                        dpIndices[i][k] = skipIdx;
                    }
                }
            }
        }

        long maxW = 0;
        List<Integer> bestIndices = new ArrayList<>();

        for (int k = 1; k <= 4; k++) {
            long w = dpWeight[n][k];
            List<Integer> idx = dpIndices[n][k];

            if (w > maxW) {
                maxW = w;
                bestIndices = idx;
            } else if (w == maxW && w > 0) {
                if (bestIndices.isEmpty() || compareIndices(idx, bestIndices) < 0) {
                    bestIndices = idx;
                }
            }
        }

        int[] result = new int[bestIndices.size()];
        for (int i = 0; i < bestIndices.size(); i++) {
            result[i] = bestIndices.get(i);
        }
        return result;
    }

    private int compareIndices(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}