class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.right == null && root.left == null))
        return root;
        TreeNode NewRoot = new TreeNode(root.val);
        NewRoot.right = invertTree(root.left);

        NewRoot.left = invertTree(root.right);

        return NewRoot;

    }
}
