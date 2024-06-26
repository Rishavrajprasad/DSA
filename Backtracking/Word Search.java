class Solution {
    int m,n;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; //left,right,up,down
    public boolean exist(char[][] board, String word) {
         m = board.length;
         n = board[0].length;
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(board[i][j] == word.charAt(0) && find(board,i,j,word,0))
                return true;
            }
        }
        return false;
    }

    boolean find(char[][] board, int i, int j, String word, int idx)
    {
        if(idx == word.length())
            return true;
        if(i<0 || j<0 || i>=m || j>=n ||board[i][j]=='$' || board[i][j] != word.charAt(idx) )
            return false;
        
        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] dir: directions)
        {
            int i_next = i+dir[0];
            int j_next = j+dir[1];
            if(find(board,i_next,j_next,word,idx+1))
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
