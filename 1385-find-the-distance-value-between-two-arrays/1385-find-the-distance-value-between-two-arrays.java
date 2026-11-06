class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        java.util.Arrays.sort(arr2);
        int distance = 0;
        
        for (int x : arr1) {
            if (!hasCloseElement(arr2, x, d)) {
                distance++;
            }
        }
        
        return distance;
    }
    
    private boolean hasCloseElement(int[] arr2, int target, int d) {
        int left = 0;
        int right = arr2.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (Math.abs(arr2[mid] - target) <= d) {
                return true;
            }
            
            if (arr2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (left < arr2.length && Math.abs(arr2[left] - target) <= d) {
            return true;
        }
        
        if (right >= 0 && Math.abs(arr2[right] - target) <= d) {
            return true;
        }
        
        return false;
    }
}