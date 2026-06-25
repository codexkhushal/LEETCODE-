 class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] freq = new int[2 * n + 1];
        
        int runningSum = 0;
        int count = 0;
        long totalSubarrays = 0; 
        
        freq[0 + n] = 1;
        int currentValidCount = 0; 

        for (int num : nums) {
            int val = (num == target) ? 1 : -1;
            
            if (val == 1) {
                currentValidCount += freq[runningSum + n];
                runningSum += 1;
            } else {
                runningSum -= 1;
                currentValidCount -= freq[runningSum + n];
            }
            
            totalSubarrays += currentValidCount;
            freq[runningSum + n]++;
        }
        
        return (int) totalSubarrays;
    }
}