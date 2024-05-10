class Solution {
    // Recursion + memo approach
    // int n;
    // int[][] dp;

    // public int longestStrChain(String[] words) {
    //     n = words.length;
    //     dp = new int[n + 1][n + 1];
    //     for(int i=0;i<=n;i++)
    //     {
    //         for(int j =0;j<=n;j++)
    //         {
    //             dp[i][j] = -1;
    //         }
    //     }
    //     Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
    //     return lis(words, 0, -1);
    // }

    // private int lis(String[] words, int curr, int prev) {
    //     if (curr >= n)
    //         return 0;
    //     if (prev != -1 && dp[prev][curr] != -1)
    //         return dp[prev][curr];
    //     int taken=0, skip;
    //     if (prev == -1 || isPred(words[prev], words[curr])) {
    //         taken = 1 + lis(words, curr + 1, curr);
    //     }
    //     skip = lis(words, curr + 1, prev);
    //     if (prev != -1)
    //         dp[prev][curr] = Math.max(taken, skip);
    //     return Math.max(taken, skip);
    // }

    public int longestStrChain(String[] words) {
       int n = words.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int max = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j =0; j<i; j++)
            {
                if(isPred(words[j], words[i]))
                {
                    dp[i]= Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
    private boolean isPred(String prev, String curr) {
        int m = prev.length();
        int n = curr.length();
        if (m >= n || n - m != 1)
            return false;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (prev.charAt(i) == curr.charAt(j))
                i++;

            j++;
        }
        return i == m;
    }
}
