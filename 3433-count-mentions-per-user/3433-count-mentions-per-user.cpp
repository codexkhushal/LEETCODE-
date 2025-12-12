class Solution {
public:
    static bool myComp(const vector<string>& a, const vector<string>& b) {

        if (a[1] != b[1]) {
            return stoi(a[1]) < stoi(b[1]);
        }
        return a[0][1] > b[0][1];
    }
    vector<int> countMentions(int numberOfUsers,
                              vector<vector<string>>& events) {

        sort(events.begin(), events.end(), myComp);

        vector<int> ans(numberOfUsers, 0);
        vector<bool> online(numberOfUsers, true);
        vector<int> offline(numberOfUsers, INT_MAX);

        for (auto& e : events) {

            string m = e[0];
            int time = stoi(e[1]);
            string op = e[2];

            for (int i = 0; i < numberOfUsers; i++) {
                if (!online[i] && offline[i] <= time) {
                    online[i] = true;
                }
            }

            if (m == "OFFLINE") {
                int id = stoi(op);
                online[id] = false;
                offline[id] = time + 60;
                continue;
            } else if (op == "ALL") {
                for (int i = 0; i < numberOfUsers; i++) {
                    ans[i]++;
                }
            } else if (op == "HERE") {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (online[i]) {
                        ans[i]++;
                    }
                }
            } else {
                string num = "";
                for (char& ch : op) {
                    if (isdigit(ch)) {
                        num += ch;
                    } else if (!num.empty()) {
                        int id = stoi(num);
                        ans[id]++;
                        num = "";
                    }
                }
                if (!num.empty()) {
                    int id = stoi(num);
                    ans[id]++;
                }
            }
        }
        return ans;
    }
};
