class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();
        int columns = l/rows;
        StringBuilder orignalText = new StringBuilder();

        for(int col = 0 ; col< columns;col++){
            for(int j = col ;j< l ; j+=(columns+1)){
                orignalText.append(encodedText.charAt(j));
            }
        }
        while(orignalText.length() > 0  && orignalText.charAt(orignalText.length()-1 ) == ' '){
            orignalText.deleteCharAt(orignalText.length() - 1);
        }

        return orignalText.toString();
    }
}