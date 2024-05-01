class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        List<Integer> parents = new ArrayList<>();
        List<Integer> rank = new ArrayList<>(Collections.nCopies(V,0));
        
        for(int i = 0;i<V;i++)
        {
            parents.add(i);
        }
        for(int i =0;i<V;i++)
        {
            for(int v: adj.get(i))
            {
                if(i<v)
                {
                    int x_parent = find(i,parents);
                    int y_parent = find(v,parents);
                    
                    if(x_parent == y_parent)
                    return 1;
                    else
                    union(i,v,parents,rank);
                }
            }
        }
        return 0;
    }
    
    private int find(int u, List<Integer> parents) {
    if (u != parents.get(u)) {
        parents.set(u, find(parents.get(u), parents)); // Path compression
    }
    return parents.get(u);
}

    
    private void union(int x, int y, List<Integer> parents, List<Integer> rank) {
    int x_parent = find(x, parents);
    int y_parent = find(y, parents);
    
    if (x_parent == y_parent)
        return;
    
    if (rank.get(x_parent) > rank.get(y_parent)) {
        parents.set(y_parent, x_parent);
    } else if (rank.get(x_parent) < rank.get(y_parent)) {
        parents.set(x_parent, y_parent);
    } else {
        parents.set(x_parent, y_parent);
        rank.set(y_parent, rank.get(y_parent) + 1); // Increment rank of the new root
    }
}

}
