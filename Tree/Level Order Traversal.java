class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
        return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            list.add(sublist);
        }
        return list;
    }
}


// Using Recursion to solve this problem (optimal solution)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        DFS(root, result, 0);
        return result;
    }

    private void DFS(TreeNode root, List<List<Integer>> result, int level)
    {
        if(result.size() == level)
        result.add(new ArrayList<>());

        result.get(level).add(root.val);

        if(root.left !=null)
        DFS(root.left,result,level+1);
        if(root.right !=null)
        DFS(root.right,result,level+1);
    }
}
