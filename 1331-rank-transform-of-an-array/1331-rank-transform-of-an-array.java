class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] Sarr = arr.clone();
        Arrays.sort(Sarr);

        HashMap<Integer , Integer > RankM = new HashMap<>();
        int rank = 1;

        for(int num : Sarr){
             if(!RankM.containsKey(num)){
                RankM.put(num, rank);
                rank++;
             }
        }
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = RankM.get(arr[i]);
        }
        return arr;
    }
}