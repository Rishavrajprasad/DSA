// Top Down Approach

class Solution {
    int [][]t =new int[1001][1001];;
    public int longestCommonSubsequence(String text1, String text2) {
        
            for(int[] num: t)
            Arrays.fill(num,-1);
       return LCS(text1,text2,text1.length(),text2.length());
    }
    int LCS(String x,String y, int n, int m)
    {
        if(n == 0 || m == 0)
            return 0;
        
        if(t[n][m] !=-1)
            return t[n][m];
        if(x.charAt(n-1) == y.charAt(m-1))
        {
            return t[n][m]= 1+ LCS(x,y,n-1,m-1);
        }
        else
            return t[n][m]= Math.max(LCS(x,y,n-1,m),LCS(x,y,n,m-1));
    }
}

// Bottom UP Approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[m][n];
    }
}
