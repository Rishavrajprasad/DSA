class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum =0;
        int n =nums.length;
        for(int i =0;i<n;i++)
            totalSum+=nums[i];
        if ((target + totalSum) % 2 != 0 || Math.abs(target) > totalSum)
            return 0;
        int sum1 = (target+totalSum)/2;
        if(sum1>totalSum)
        return 0;
        return solve(nums,sum1);
    }
    private int solve(int[] nums,int sum)
    {
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];

        for(int i =0;i<n+1;i++)
        {
            for(int j =0;j<sum+1;j++)
            {
                if(i ==0)
                dp[i][j] = 0;
                if(j==0)
                dp[i][j] = 1;
            }
        }
        for(int i =1;i<n+1;i++)
        {
            for(int j =0; j<sum+1;j++)
            {
                if(nums[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }
}
