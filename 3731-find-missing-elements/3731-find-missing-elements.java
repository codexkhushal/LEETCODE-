

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        List<Integer> missingElements = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!numSet.contains(i)) {
                missingElements.add(i);
            }
        }
        
        Collections.sort(missingElements);
        
        return missingElements;
    }
}