class Solution {
public:
    int areaOfMaxDiagonal(vector<vector<int>>& dimensions) {
        int maxDiagonalLength = -1;
        int maxArea = 0;
        for (vector<int>& point : dimensions){
            int curDiagonalLength = point[0] * point[0] + point[1] * point[1];
            if (curDiagonalLength == maxDiagonalLength) {
                maxArea = max(maxArea, point[0] * point[1]);
            }
            else if (curDiagonalLength > maxDiagonalLength) {
                maxDiagonalLength = curDiagonalLength;
                maxArea = point[0] * point[1];
            }
        }
        return maxArea;
    }
};
