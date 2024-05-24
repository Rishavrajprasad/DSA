class Solution {
    int m,n,nonObstacles,result=0;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; //left,right,up,down
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        nonObstacles =0;
        int x=0,y=0;
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(grid[i][j]==0)
                nonObstacles++;
                if(grid[i][j] == 1)
                    {
                        x=i;
                        y=j;
                    }
            }
        }
        nonObstacles+=1;
        backtrack(grid,0,x,y);
        return result;
    }

    void backtrack(int[][] grid, int count,int i,int j)
    {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == -1)
        return;

        if(grid[i][j] == 2)
        {
            if(count == nonObstacles)
            {
                result++;  
            }
            return;
        }
        grid[i][j]= -1;
         for(int[] dir: directions)
        {
            int i_next = i+dir[0];
            int j_next = j+dir[1];
            backtrack(grid,count+1,i_next,j_next);
        }
        grid[i][j]=0;
    }
}
