class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        vector<vector<pair<int, int>>> g(n);
        for(int i=0;i<meetings.size();i++) {
            g[meetings[i][0]].push_back({meetings[i][1], meetings[i][2]});
            g[meetings[i][1]].push_back({meetings[i][0], meetings[i][2]});
        }

        priority_queue<pair<int,int> , vector<pair<int,int> > , greater<pair<int,int>> > pq;

        pq.push({0, 0});
        pq.push({0, firstPerson});

        vector<int> ans;

        vector<bool> vis(n, false);

        while(!pq.empty()) {
            int p = pq.top().second;
            int time = pq.top().first;

            pq.pop();

            if(vis[p]) continue;

            vis[p] = 1;

            for(auto& gt: g[p]) {
                if(!vis[gt.first] && time <= gt.second) {
                    pq.push({gt.second, gt.first});
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(vis[i]) ans.push_back(i);
        }
        return ans;

    }
};