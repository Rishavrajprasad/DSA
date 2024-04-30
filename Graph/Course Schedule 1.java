import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency matrix for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Populate adjacency list based on prerequisites
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            adjList.get(from).add(to);
        }
        
        // Initialize visited and inRecursion lists
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        
        // Perform DFS from each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, adjList, visited, inRecursion)) {
                return false; // Cycle detected
            }
        }
        
        return true; // No cycle detected
    }

    private boolean hasCycle(int u, List<List<Integer>> adjList, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                if (hasCycle(v, adjList, visited, inRecursion)) {
                    return true; // Cycle detected deeper in recursion
                }
            } else if (inRecursion[v]) {
                return true; // Cycle detected
            }
        }
        
        inRecursion[u] = false; // Backtrack
        return false; // No cycle detected
    }
}
