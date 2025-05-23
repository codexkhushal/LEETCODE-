class Solution {
public:
    string minWindow(string s, string t) {
        if (t.length() > s.length())
            return "";

        unordered_map<char, int> targetFreq;
        for (char c : t) {
            targetFreq[c]++;
        }

        int start = 0, minLen = INT_MAX, minStart = 0;
        int i = 0, count = 0;
        unordered_map<char, int> windowFreq;

        for (int j = 0; j < s.size(); ++j) {
            char endChar = s[j];
            windowFreq[endChar]++;

            if (targetFreq.count(endChar) &&
                windowFreq[endChar] <= targetFreq[endChar]) {
                count++;
            }

            while (count == t.size()) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    minStart = i;
                }

                char startChar = s[i];
                windowFreq[startChar]--;
                if (targetFreq.count(startChar) &&
                    windowFreq[startChar] < targetFreq[startChar]) {
                    count--;
                }
                i++;
            }
        }

        return (minLen == INT_MAX) ? "" : s.substr(minStart, minLen);
    }
};
