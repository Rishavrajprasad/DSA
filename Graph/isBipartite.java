class Solution {

    // Main function to check if the graph is bipartite
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // Number of nodes in the graph
        int[] color = new int[n]; // Array to store color of each node
        Arrays.fill(color, -1); // Initialize color array with -1 (unvisited)

        // Check each node for bipartiteness
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // If node i is unvisited
                if (!dfs(graph, i, color, 1)) // Start DFS from node i with color 1
                    return false; // Graph is not bipartite
            }
        }
        return true; // Graph is bipartite
    }

    // Depth-first search (DFS) function to traverse the graph and check bipartiteness
    public boolean dfs(int[][] graph, int u, int[] color, int colorV) {
        color[u] = colorV; // Color current node u with colorV

        // Explore all neighbors of node u
        for (int v : graph[u]) {
            if (color[v] == color[u]) // If neighbor v has the same color as node u
                return false; // Graph is not bipartite

            if (color[v] == -1) { // If neighbor v is unvisited
                int newColor = 1 - colorV; // Assign opposite color to neighbor v
                if (!dfs(graph, v, color, newColor)) // Recursively visit neighbor v
                    return false; // Graph is not bipartite
            }
        }
        return true; // All nodes visited without conflicts, graph is bipartite
    }
}
