/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(nums.length == 0)
        return null;
        if(nums.length == 1)
        return new TreeNode(nums[0]); 
        int l =0;
        int r=n-1;
        return BST(nums,l,r);
    }
    private TreeNode BST(int[] nums, int l, int r)
    {
        if(l>r)
        return null;
        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums,l,mid-1);
        root.right = BST(nums,mid+1,r);
        return root;
    }
    
}
