// ******************Intuition******************************
// *********************************************************
//             saare nodes left to right hone chahiye to hum BFS ka logic lgaege and hrek node s puchege ki kya past m kbhi null aaya h
//             qki ek baar null aagya to aage koi not null node nai ho skta agr hua to wo complete binary tree nai rhega

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        boolean past  = false; //past mein kabhi null nhi dekha
        queue.add(root);
        while(!queue.isEmpty())
        {   
            TreeNode temp = queue.poll();
            if(temp == null) // agar mera node ka value null hai toh hum past ko true mark kr denge it means i saw the null node
            {
                past = true;
            } else 
            {
                if(past == true) // agar past mein null node dekhe toh return kar denge false kyunki yeh binary tree complete nhi hai
                return false;
                else // agar past mein kabhi null nhi mila tha toh left aur right ko queue mein push kr denge 
                {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }
        return past;
    }
}

/*****************DFS******************/
// Array mein tree ka value story karenge, agar jb bhi index>total no. of nodes hua then return false ho jayega


class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return dfs(root,1,totalNodes);
    }
    private int countNodes(TreeNode root)
    {
        if(root == null)
        return 0;

        return 1+countNodes(root.left)+countNodes(root.right);
    }

    private boolean dfs(TreeNode root,int i, int totalNodes)
    {
        if(root == null)
        return true;

        if(i>totalNodes)
        return false;

        return dfs(root.left,2*i,totalNodes) && dfs(root.right, 2*i+1,totalNodes);
    }
}
