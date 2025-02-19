class Solution {
public:
    int solve(TreeNode* root, int curr) {
        if (!root) return 0;
        curr = curr * 10 + root->val;

        if (!root->left && !root->right)
         return curr;
         
        return solve(root->left, curr) + solve(root->right, curr);
    }

    int sumNumbers(TreeNode* root) {
        return solve(root, 0);
    }
};
