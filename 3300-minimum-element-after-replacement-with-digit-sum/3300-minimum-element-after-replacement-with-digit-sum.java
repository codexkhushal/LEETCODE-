class Solution {
    public int minElement(int[] nums) {
        int sum = Integer.MAX_VALUE;
        
        for(int num : nums){
            int cSum = 0 ;
            int temp = num;

            while(temp>0){
                cSum += temp%10;
                temp /= 10;
            }
            if(cSum< sum){
                sum = cSum;
            }
        }
        return sum;
    }
}