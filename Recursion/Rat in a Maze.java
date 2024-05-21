class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        solve(0, 0, m, path, result, n);
        return result;
    }

    private static void solve(int i, int j, int[][] m, ArrayList<String> path, ArrayList<String> result, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n || m[i][j] == 0) {
            return;
        }

        // Check if we have reached the bottom-right corner
        if (i == n - 1 && j == n - 1) {
            result.add(String.join("", path));
            return;
        }

        // Mark the cell as visited
        m[i][j] = 0;

        // Move left
        path.add("L");
        solve(i, j - 1, m, path, result, n);
        path.remove(path.size() - 1);

        // Move right
        path.add("R");
        solve(i, j + 1, m, path, result, n);
        path.remove(path.size() - 1);

        // Move up
        path.add("U");
        solve(i - 1, j, m, path, result, n);
        path.remove(path.size() - 1);

        // Move down
        path.add("D");
        solve(i + 1, j, m, path, result, n);
        path.remove(path.size() - 1);

        // Unmark the cell as visited
        m[i][j] = 1;
    }
