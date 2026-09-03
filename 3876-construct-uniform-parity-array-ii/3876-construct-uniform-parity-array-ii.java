class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOddVal = Integer.MAX_VALUE;
        int minEvenVal = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 != 0) {
                minOddVal = Math.min(minOddVal, num);
            } else {
                minEvenVal = Math.min(minEvenVal, num);
            }
        }

       
        return minOddVal == Integer.MAX_VALUE || minOddVal < minEvenVal;
    }
}