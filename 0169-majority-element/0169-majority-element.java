class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int i = 0 ;
        for( i = 0 ; i < n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
             if(mp.get(nums[i])>n/2){
            return nums[i];
        }
        }
       
         return -1;
    }
    
}