
class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        map<int,map<int,multiset<int>>>nodes;
        queue<pair<TreeNode*,pair<int,int>>>q;
        q.push({root,{0,0}});
        while(!q.empty()){
            auto t = q.front();
            q.pop();
            TreeNode* a = t.first;
            int x =t.second.first, y = t.second.second;
            nodes[x][y].insert(a->val);
            if(a->left){
                q.push({a->left,{x-1,y+1}});
            }
            if(a->right){
                q.push({a->right,{x+1,y+1}});
            }

        }
        vector<vector<int>>ans;
        for(auto p: nodes){
            vector<int>col;
            for(auto b:p.second){
                col.insert(col.end(),b.second.begin(),b.second.end());
            }
            ans.push_back(col);
        }
        return ans;
    }
};