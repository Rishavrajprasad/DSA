class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root,res);
        return res[0];
    }

    int solve(TreeNode root, int[] res)
    {
        if(root == null)
            return 0;
        
        int l = solve(root.left,res);
        int r = solve(root.right,res);

        int temp = Math.max(Math.max(l,r)+root.val, root.val);
        int ans =Math.max(temp,l+r+root.val);
        res[0] = Math.max(res[0],ans);
        return temp;
    }
}
