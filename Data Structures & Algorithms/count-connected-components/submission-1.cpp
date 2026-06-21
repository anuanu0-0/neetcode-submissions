class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n);
        vector<bool> vis(n, false);
        for(const auto& edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        int count = 0;
        for(int node=0; node<n; node++){
            if(!vis[node]){
                // bfs(node, adj, vis);
                dfs(node, adj, vis);
                count++;
            }
        }
        return count;
    }

    void dfs(int node, vector<vector<int>> &adj, vector<bool> &vis) {
        vis[node] = true;
        for(int n: adj[node]) {
            if (!vis[n]) {
                dfs(n, adj, vis);
            }
        }
    }

    void bfs(int node, vector<vector<int>> &adj, vector<bool> &vis) {
        queue<int> q;
        q.push(node);
        vis[node]=true;

        while(!q.empty()){
            int cur = q.front();
            q.pop();
            for(int n: adj[cur]){
                if(!vis[n]){
                    vis[n]=true;
                    q.push(n);
                }
            }
        }
    }
};
