class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0 ;
        int right = numbers.length - 1;

        while(left<right){
            int cSum = numbers[left] + numbers[right];

            if(cSum == target){
                return new int[]{left+1 , right+1};
            }else if(cSum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}