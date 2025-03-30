class Solution {
public:
    vector<int> partitionLabels(string s) {
        // Step 1: Store the last occurrence of each character
        unordered_map<char, int> lastOccurrence;
        for (int index = 0; index < s.length(); index++) {
            lastOccurrence[s[index]] = index;
        }

        vector<int> partitionSizes;
        int partitionStart = 0, partitionEnd = 0;

        // Step 2: Iterate and determine partitions
        for (int index = 0; index < s.length(); index++) {
            partitionEnd = max(partitionEnd, lastOccurrence[s[index]]);
            if (index == partitionEnd) {
                partitionSizes.push_back(partitionEnd - partitionStart + 1);
                partitionStart = index + 1;
            }
        }
        return partitionSizes;
    }
};
