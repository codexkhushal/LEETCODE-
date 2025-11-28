class Solution {
public:
    class Graph {
        int V;
        list<int> *l;
    public:
        Graph(int V) {
            this->V = V;
            l = new list<int>[V];
        }

        void addEdge(int u, int v) {
            l[u].push_back(v);
            l[v].push_back(u);
        }

        int ans = 0;

        int dfs(int curr, int par, vector<int> &val, int K) { 
            int sum = val[curr];

            list<int> neighbour = l[curr];
            for(int &v : neighbour) {
                if(v != par) { 
                    sum += dfs(v, curr, val, K);

                    sum %= K; 
                }
            }

            sum %= K;

            if(sum == 0) {
                ans++;
            }

            return sum;
        }
    };

    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
        Graph graph(n);

        for(vector<int> &edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.addEdge(u, v);
        }

        graph.dfs(0, -1, values, k);

        return graph.ans;
    }
};