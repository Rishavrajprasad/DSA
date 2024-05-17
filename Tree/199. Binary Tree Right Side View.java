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
    ArrayList <Integer> list  = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        tree(root,list,0);
        return list;
    }
    private void tree(TreeNode root,ArrayList<Integer> list, int depth)
    {
        if(root == null) 
        return ;
        if(list.size() == depth)
        list.add(root.val);
        if(root.right !=null)
        tree(root.right,list,depth+1);
        if(root.left !=null)
        tree(root.left,list,depth+1);
    }
}
