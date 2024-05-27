class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] t;
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        t = new int[n+1][W+1];
        for(int[] nums: t)
        {
            Arrays.fill(nums,-1);
        }
         return solve(W,wt,val,n);
    } 
    private static int solve(int W, int wt[], int val[], int n)
    {
        if( n==0 || W==0)
        return 0;
        
        if(t[n][W] != -1 )
            return t[n][W];
        
        if(wt[n-1]<=W)
        {
            return t[n][W] = Math.max(val[n-1]+solve(W-wt[n-1], wt,val,n-1),solve(W,wt,val,n-1) );
        }else{
            return t[n][W] = solve(W,wt,val,n-1);
        }
    }
    
}


// Buttom Up Approach
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int t[][] = new int[1001][1001];
         for(int i =0;i<n+1;i++)
         {
             for(int j = 0; j<W+1;j++)
             {
                 if(i == 0 || j == 0)
                 t[i][j] = 0;
             }
         }
         for(int i=1;i<n+1;i++)
         {
             for(int j =1; j<W+1;j++)
             {
                 if(wt[i-1]<=j)
                 t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], 0+t[i-1][j]);
                 else
                 t[i][j] =0+ t[i-1][j];
             }
         }
         
         return t[n][W];
    } 
}

