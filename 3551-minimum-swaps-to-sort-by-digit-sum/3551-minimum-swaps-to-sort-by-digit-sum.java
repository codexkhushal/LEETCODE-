import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = nums[i];
            items[i][1] = getDigitSum(nums[i]);
        }
        
        Arrays.sort(items, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(items[i][0], i);
        }
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || items[i][0] == nums[i]) {
                continue;
            }
            
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = valueToIndex.get(nums[j]);
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}