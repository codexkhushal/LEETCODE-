class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] present = new boolean[2048];
        int uniqueCount = 0;
        for (int num : nums) {
            if (!present[num]) {
                present[num] = true;
                uniqueCount++;
            }
        }

        int[] u = new int[uniqueCount];
        int idx = 0;
        for (int i = 0; i < 2048; i++) {
            if (present[i]) {
                u[idx++] = i;
            }
        }

        boolean[] pairXor = new boolean[2048];
        for (int i = 0; i < uniqueCount; i++) {
            for (int j = i; j < uniqueCount; j++) {
                pairXor[u[i] ^ u[j]] = true;
            }
        }

        boolean[] tripletXor = new boolean[2048];
        for (int p = 0; p < 2048; p++) {
            if (pairXor[p]) {
                for (int x : u) {
                    tripletXor[p ^ x] = true;
                }
            }
        }

        int ans = 0;
        for (boolean b : tripletXor) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}