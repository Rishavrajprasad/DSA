import java.util.Arrays;

class Solution {
    //  Recursion + Memo
    // int n;
    // long[][] t;

    // public long maxAlternatingSum(int[] nums) {
    //     n = nums.length;
    //     t = new long[n][2];
    //     for (long[] row : t) {
    //         Arrays.fill(row, -1);
    //     }
    //     return solve(0, nums, true);
    // }

    // private long solve(int idx, int[] nums, boolean isEven) {
    //     if (idx >= n) {
    //         return 0;
    //     }
    //     if (t[idx][isEven ? 1 : 0] != -1) {
    //         return t[idx][isEven ? 1 : 0];
    //     }

    //     long skip = solve(idx + 1, nums, isEven);

    //     long val = nums[idx];
    //     if (!isEven) {
    //         val = -val;
    //     }

    //     long take = solve(idx + 1, nums, !isEven) + val;

    //     long result = Math.max(skip, take);
    //     t[idx][isEven ? 1 : 0] = result;

    //     return result;
    // }


    // bottom up approach
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long dp[][] = new long[n+1][2];

        for(int i = 1;i<n+1;i++)
        {
            dp[i][0] = Math.max(dp[i-1][1]-nums[i-1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+nums[i-1], dp[i-1][1]);
        }

        return Math.max(dp[n][0],dp[n][1]);
    }


}
