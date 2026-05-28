class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int count = 0 ;
        boolean foundWord = false;
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(ch !=' '){
                count++;
                foundWord = true;
            }else{
                if(foundWord)break;
            }
        }
        return count;
    }
}