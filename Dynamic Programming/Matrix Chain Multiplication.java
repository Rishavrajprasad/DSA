class Solution{
    static int[][] t;
    static int matrixMultiplication(int N, int arr[])
    {
        t= new int[N+1][N+1];
        for(int[] num: t)
        Arrays.fill(num, -1);
        return solve(arr,1,N-1);
    }
    static int solve(int[] arr, int i, int j)
    {
        if(i>=j)
        return 0;
        
        if(t[i][j] != -1)
        return t[i][j];
        t[i][j] = Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++)
        {
            int temp = solve(arr,i,k)+solve(arr,k+1,j)+ (arr[i-1] *arr[k]*arr[j]);
            t[i][j]= Math.min(t[i][j],temp);
        }
        return t[i][j];
    }
}
