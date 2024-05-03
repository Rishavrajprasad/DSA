class Solution {
    private int[] parent;
    private int[] rank;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < (n-1))
        return -1;
        parent = new int[n];
        rank   = new int[n];
        for(int i =0;i<n;i++)
        {
            parent[i] = i;
            rank[i]   = 0;
        }
        int component = n;
        for(int[] conn: connections)
        {
            int v = conn[0];
            int u = conn[1];

            if(find(u) != find(v))
            {
                union(u,v);
                component--;
            }
        }
        return component-1;
    }

    private int find(int x)
    {
        if(x != parent[x])
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union (int x, int y)
    {
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent == y_parent)
        return;
        if(rank[x_parent] > rank[y_parent])
        {
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent])
        {
            parent[x_parent] = y_parent;
        }
        else
        {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

}
