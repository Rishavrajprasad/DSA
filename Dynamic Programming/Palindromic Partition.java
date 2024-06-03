class Solution{
    static int[][] dp;
    static int palindromicPartition(String str)
    {
        int n = str.length();
        dp = new int[n+1][n+1];
        for(int[] arr: dp)
        Arrays.fill(arr,-1);
       return solve(str,0,str.length()-1);
    }
    
    static int solve(String str, int i, int j)
    {
        if(i>=j){
        return 0;}
        if(dp[i][j] != -1){
        return dp[i][j];}
        if(isPalindrome(str,i,j)){
        return 0;}
        int left ,right;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++)
        {
            if(dp[i][k] != -1)
            {
                left = dp[i][k];
            }
            else
            {
                left = solve(str,i,k);
                dp[i][k] = left;
            }
            if(dp[k+1][j] !=-1)
            {
                right = dp[k+1][j];
            }
            else
            {
                right = solve(str,k+1,j);
                dp[k+1][j] = right;
            }
            
            int temp = left+right+1;
            ans = Math.min(ans,temp);
        }
        return dp[i][j]= ans;
    }
    static boolean isPalindrome(String s, int i, int j) {
    while (i <= j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}
    
    
    
}
