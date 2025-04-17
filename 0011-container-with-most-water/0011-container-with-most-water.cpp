class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        int i =0 , j = n -1 ;
        int water = 0 ;
        while(i<j){
            int w = j-i ;
            int h = min(height[i] , height[j]);
            int area = w * h ;
            water = max(water , area);
            if(height[i] > height[j]){
                j--;
            }else {
                i++;
            }

        }
        return water; 
    }
};