class Solution {
public:
    int lengthLongestPath(string input) {
        stack<int> st;
        st.push(0); 
        int maxLen = 0;

        stringstream ss(input);
        string line;

        while (getline(ss, line)) {
            int level = line.find_last_of('\t') + 1;
            while (level + 1 < st.size()) {
                st.pop();
            }

            int len = st.top() + line.length() - level + 1; 
            st.push(len);

            if (line.find('.') != string::npos) {
                maxLen = max(maxLen, len - 1); 
            }
        }

        return maxLen;
    }
};
