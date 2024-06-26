class Solution{
    private static final int MOD = 1_000_000_007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][] = new int[n+1][sum+1];
	    for(int i =0;i<n+1;i++)
	    {
	       dp[i][0] = 1;
	    }
	    for(int i =1;i<n+1;i++)
	    {
	        for(int j =0;j<sum+1;j++)
	        {
	            if(arr[i-1] <=j)
	            {
	                dp[i][j] = (dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]) % MOD;
	            }
	            else
	            dp[i][j] = dp[i-1][j];
	        }
	    }
	    
	    return dp[n][sum];
	} 
}
