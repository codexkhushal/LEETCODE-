class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalS = 0; 
        int currentS= 0; 
        int startS = 0;
        int n = gas.length;
        for(int i = 0 ; i<n ;i++){
            int netG = gas[i] - cost[i];
            totalS += netG;
            currentS += netG;

            if(currentS < 0 ){
                startS = i+1;
                currentS= 0;
            }
        }
        if(totalS < 0 ){
            return -1;
        }else{
            return startS;
        }
    }
}