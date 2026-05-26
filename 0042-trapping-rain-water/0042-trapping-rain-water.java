class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int right = height.length - 1 ;
        int rightM = 0;
        int left = 0 ; 
        int leftM = 0;
        int totalW = 0 ;
        
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftM){
                leftM = height[left];
            }else{
                totalW += leftM - height[left];
            }

             left++;
            }else{
                if(height[right]>= rightM){
                    rightM = height[right];
                }else{
                    totalW += rightM - height[right];
                }
                right--;
            }
        }
        return totalW;
    }
}