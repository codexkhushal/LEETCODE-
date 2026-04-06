class Solution {
    public int compress(char[] c) {
        int write=0, read=0;
        while(read<c.length){
            char curr= c[read];
            int cnt=0;
            while(read<c.length && c[read]==curr){
                cnt++;
                read++;
            }
            if(cnt>1){
                c[write++]=curr;
                for(char t:String.valueOf(cnt).toCharArray()) c[write++]=t;
            }else{
                c[write++]=curr;
            }
        }
        return write;
    }
}