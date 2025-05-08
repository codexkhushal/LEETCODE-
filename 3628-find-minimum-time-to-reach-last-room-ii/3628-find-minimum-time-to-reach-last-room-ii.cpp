class Solution {
public:
    typedef pair<int, int> pii;
    typedef pair<int, bool> pib;
    int minTimeToReach(vector<vector<int>>& moveTime) {
        int n = moveTime.size(), m = moveTime[0].size();
        priority_queue<pair<pib, pii>, vector<pair<pib, pii>>, greater<>> pq;
        vector<vector<bool>> vis(n, vector<bool>(m));
        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));
        moveTime[0][0] = 0;
        vis[0][0] = 0;
        dist[0][0] = 0;
        pq.push({{0, false}, {0, 0}});
        while (!pq.empty()) {
            int time = pq.top().first.first;
            bool extra = pq.top().first.second;
            int x = pq.top().second.first;
            int y = pq.top().second.second;
            pq.pop();
            if (x == n - 1 and y == m - 1)
                return time;
            int dx[] = {-1, 0, 1, 0};
            int dy[] = {0, 1, 0, -1};
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 or ny < 0 or nx > n - 1 or ny > m - 1 or vis[nx][ny])
                    continue;
                int timeTaken = max(time, moveTime[nx][ny]);
                if (timeTaken < dist[nx][ny]) {
                    dist[nx][ny] = timeTaken + 1 + extra;
                    vis[nx][ny] = true;
                    pq.push({{timeTaken + 1 + extra, !extra}, {nx, ny}});
                }
            }
        }
        return -1;
    }
};
