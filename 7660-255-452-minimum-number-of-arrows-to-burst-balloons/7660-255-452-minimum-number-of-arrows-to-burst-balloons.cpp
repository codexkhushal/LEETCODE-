bool sortcol(const vector<int> &v1,const vector<int> &v2)
    {
        return v1[1] < v2[1];
    }
class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
    sort(points.begin(), points.end(), sortcol);
    int cnt = 1;
    int end=points[0][1];
    for (int i = 1; i < points.size(); i++)
    {
        if(points[i][0]>end)
        {
            cnt++;
            end=points[i][1];
        }
    }
    return cnt;
        
    }
};