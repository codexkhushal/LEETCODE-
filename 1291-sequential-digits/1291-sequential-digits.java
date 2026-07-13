class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for(int i = 1 ; i <= 9 ; i++){
            int num = i; 
            int nextDigit = i+1;

            while(num <= high && nextDigit <= 9){
                num = num * 10 + nextDigit;

                if(num >= low && num <= high ){
                    result.add(num);
                }
                nextDigit++;
                
            }
        }
        Collections.sort(result);
        return result;
    }
}