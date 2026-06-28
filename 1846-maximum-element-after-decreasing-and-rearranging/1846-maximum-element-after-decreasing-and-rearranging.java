class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        int maxV = -1 ;
        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i++){
            if(i==0){
                arr[0] = 1;
            }else if(Math.abs(arr[i] - arr[i-1]) > 1){
                arr[i] = arr[i-1] + 1 ;

            }
            maxV = Math.max(maxV , arr[i]);
        }
        return maxV;
    }
}