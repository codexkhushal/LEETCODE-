class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        
        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            int numWords = j - i;
            
           
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            else {
                int totalSpaces = maxWidth - (lineLength - (numWords - 1));
                int gaps = numWords - 1;
                int baseSpaces = totalSpaces / gaps;
                int remainderSpaces = totalSpaces % gaps;
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        // Add base spaces
                        for (int s = 0; s < baseSpaces; s++) {
                            sb.append(" ");
                        }
                        if (remainderSpaces > 0) {
                            sb.append(" ");
                            remainderSpaces--;
                        }
                    }
                }
            }
            
            result.add(sb.toString());
            i = j; 
        }
        
        return result;
    }
}