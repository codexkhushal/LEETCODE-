class Solution {
public:
    int countCompleteSubarrays(vector<int>& A) {
        int maxVal = *max_element(A.begin(), A.end());
        vector<int> freq(maxVal + 1), seen(maxVal + 1);
        for (int x : A)
            seen[x] = 1;
        int totalUnique = accumulate(seen.begin(), seen.end(), 0);
        int res = 0, left = 0, unique = 0;

        for (int right = 0; right < A.size(); ++right) {
            if (++freq[A[right]] == 1)
                ++unique;
            while (unique == totalUnique) {
                res += A.size() - right;
                if (--freq[A[left++]] == 0)
                    --unique;
            }
        }
        return res;
    }
};
