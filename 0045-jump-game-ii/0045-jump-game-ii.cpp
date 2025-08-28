class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n <= 1) return 0;

        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        for(int i = 0; i < n - 1; i++) {
            farthest = max(farthest, i + nums[i]);
            if(i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
};

// i==0 
// farthest = max(0 , 0+2)
// farthest = 2
// i==currentend  (0 == 0){
//     jump = 1 
//     curret end = 2 ;
// }

// i==1 
// farthset = (2 , 1 + 3)
// farthest = 4 
// i!= currentend 

// i == 2 
// i==2 === 0 
// farthrsy = 4 , 2 + 0 

// fartehst = 4 
// jump ++ 
// currentedn = 4 

// i == 3 
// fartherst = (4 , 3+ 1){
//     farthest = 4 
// }
