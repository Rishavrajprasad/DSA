class Solution {
    // Declare an array 'dp' to store computed results for dynamic programming.
    int[] dp = new int[101];

    // Main method to calculate maximum amount that can be robbed.
    public int rob(int[] nums) {
        int n = nums.length;  // Length of the input array 'nums'.
        
        // Fill the dp array with -1 to indicate that no values have been computed yet.
        Arrays.fill(dp, -1);
        
        // Call the recursive solve method starting from index 0.
        return solve(nums, 0, n);
    }

    // Recursive method to calculate the maximum amount that can be robbed starting from index 'i'.
    public int solve(int[] nums, int i, int n) {
        // Base case: If current index 'i' is beyond the last index 'n', return 0 (no more houses to rob).
        if (i >= n) return 0;
        
        // If the value for 'dp[i]' has already been computed, return it.
        if (dp[i] != -1)
            return dp[i];
        
        // Calculate the maximum amount if we choose to rob the current house ('steal') or skip it ('skip').
        int steal = nums[i] + solve(nums, i + 2, n);  // Rob current house and recursively rob the next house.
        int skip = solve(nums, i + 1, n);             // Skip current house and move to the next one.
        
        // Store the maximum amount that can be robbed starting from index 'i' in 'dp[i]'.
        return dp[i] = Math.max(steal, skip);
    }
}
