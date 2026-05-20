class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            setA.add(A[i]);
            setB.add(B[i]);
            int cc = 0;

            for(int num :setA){
                if(setB.contains(num)){
                    cc++;
                }
            }
            c[i] = cc;
        }
        return c;
    }
}