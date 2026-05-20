class Solution {
    public int jump(int[] nums) {
        int jumps = 0 ; 
        int curE = 0 ;
        int furthest = 0 ;

        for(int i = 0 ; i < nums.length-1;i++){
            furthest = Math.max(furthest,i+nums[i]);
            if(i==curE){
                jumps++;
                curE = furthest;
            }
        }
        return jumps;
    }
}