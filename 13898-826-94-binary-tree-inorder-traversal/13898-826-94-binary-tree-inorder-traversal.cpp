
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int>res;
        DFS(root,res);
        return res;
    }
private:
    void DFS(TreeNode* r, vector<int>& res)
    {
        if(r==NULL)
        return;
        DFS(r->left,res);
        res.push_back(r->val);
        DFS(r->right,res);
    }
};