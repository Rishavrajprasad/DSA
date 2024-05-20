class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        DFS(root, result, 0);
        return result;
    }

    private void DFS(TreeNode root, List<List<Integer>> result, int level) {
        if(result.size() == level)
            result.add(new ArrayList<>());

        if(level % 2 == 0)
            result.get(level).add(root.val);  // add to the end for even levels
        else
            result.get(level).add(0, root.val);  // add to the beginning for odd levels

        if(root.left != null)
            DFS(root.left, result, level + 1);
        if(root.right != null)
            DFS(root.right, result, level + 1);
    }
}
