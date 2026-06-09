class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > maxVal){
                maxVal = num;
            }
            if(num < minVal){
                minVal = num;
            }
        }
        long SingleSubarray = (long) maxVal - minVal;

        return SingleSubarray*k;
    }
}