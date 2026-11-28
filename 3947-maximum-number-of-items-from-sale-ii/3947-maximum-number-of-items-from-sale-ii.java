import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            if (item[0] > maxFactor) {
                maxFactor = item[0];
            }
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] multiplesCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] == 0) {
                continue;
            }
            for (int m = f; m <= maxFactor; m += f) {
                multiplesCount[f] += freq[m];
            }
        }

        int[][] sorted = Arrays.copyOf(items, n);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[1]));

        long remainingBudget = budget;
        long totalItems = 0;

        for (int[] item : sorted) {
            int factor = item[0];
            long price = item[1];

            if (price >= 2 * minPrice) {
                continue;
            }
            if (remainingBudget < price) {
                break;
            }

            long freeCapacity = multiplesCount[factor] - 1;
            if (freeCapacity > 0) {
                long affordable = remainingBudget / price;
                long take = Math.min(freeCapacity, affordable);

                totalItems += take * 2;
                remainingBudget -= take * price;
            }
        }

        totalItems += remainingBudget / minPrice;

        return (int) totalItems;
    }
}