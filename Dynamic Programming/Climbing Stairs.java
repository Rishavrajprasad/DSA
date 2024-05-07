// class Solution {
//     int[] dp = new int[46];
//     public int climbStairs(int n) {
//         Arrays.fill(dp,-1);
//         return solve(n);
//     }
//     public int solve(int n)
//     {
//         if(n<0)
//         return 0;
//         if(n == 0)
//         return 1;
//         if(dp[n] != -1)
//         return dp[n];
//         int a = solve(n-1);
//         int b = solve(n-2);
//         return dp[n] = a+b;
//     }
// }

//  Bottom Up approach
class Solution {
    
    // public int climbStairs(int n) {
    //     if(n<=2)
    //     return n;
    //     int[] dp = new int[n+1];
    //     dp[0]= 0;
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     for(int i =3;i<=n;i++)
    //     {
    //         dp[i] = dp[i-1]+ dp[i-2];
    //     }
    //     return dp[n];
    // }

    // Optimised way
    public int climbStairs(int n)
    {
        if(n<=2)
        return n;
        int a =1;
        int b =2;
        int c =3;

        for(int i = 3;i<=n;i++)
        {
            c = a + b;
            int temp = b;
            b=c;
            a = temp;
        }
        return c;
    }
    
}
