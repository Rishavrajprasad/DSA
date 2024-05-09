class Solution {
    // int dp[][], n;

    // public int lengthOfLIS(int[] nums) {
    // n = nums.length;
    // dp = new int[2501][2501];
    // for (int[] row : dp) {
    // Arrays.fill(row, -1);
    // }
    // return solve(nums, 0, -1);
    // }

    // int solve (int[] nums, int i, int prev)
    // {
    // if(i==n)
    // return 0;

    // if (prev != -1 && dp[prev][i] != -1){
    // return dp[prev][i];}
    // int take =0;
    // if(prev == -1 || nums[i] > nums[prev]){
    // take = 1 + solve(nums,i+1,i);
    // }
    // int skip = solve(nums,i+1,prev);

    // if(prev != -1)
    // dp[prev][i] = Math.max(take,skip);
    // return Math.max(take,skip);
    // }

    // Bottom Up Approach
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxLis =1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLis = Math.max(maxLis, dp[i]);
                }
            }
        }

        return maxLis;
    }

}
