class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] t = new int[n+1][m+1];
        int res = 0;
        int length =0;
        for(int i =1;i<n+1;i++)
        {
            for(int j =1;j<m+1;j++)
            {
                if(S1.charAt(i-1) == S2.charAt(j-1))
                {
                    t[i][j] =1+ t[i-1][j-1];
                    res = Math.max(t[i][j],res);
                }
                else{
                    t[i][j] =0;
                }
            }
        }
        return res;
    }
    
}
