/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    // //maxheap
    // public int kthSmallest(TreeNode root, int k) {
    // root = tree(root,k);
    // return pq.peek();
    // }
    // private TreeNode tree(TreeNode root,int k)
    // {
    // if(root == null)
    // return null;

    // pq.add(root.val);
    // if(pq.size()>k)
    // {
    // pq.poll();
    // }
    // root.left = tree(root.left,k);
    // root.right = tree(root.right,k);
    // return root;
    // }
    int count=0;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;}

   public void inOrder(TreeNode root, int k){
       if(root==null){
           return;
       }
       inOrder(root.left,k);
       count++;
       if(k==count){
           ans=root.val;
           return;}
       inOrder(root.right,k);
   }

}
