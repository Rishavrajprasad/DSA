static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] t = new boolean[N+1][sum+1];
        for(int i = 0;i<N+1;i++)
        {
            for(int j =0; j<sum+1;j++)
            {
                if(i==0)
                t[i][j] = false;
                if(j == 0)
                t[i][j] = true;
            }
        }
        
        for(int i = 1;i<N+1;i++)
        {
            for(int j =1; j<sum+1;j++)
            {
                if(arr[i-1]<=sum)
                {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][sum];
}



//  Recursion + memo
class Solution{

    static Boolean t[][];
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here7
         t = new Boolean[N+1][sum+1];
        for(int i = 0; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                t[i][j] = null;
            }
        }
        return solve(N,arr,sum);
    }
    
    static boolean solve(int N, int arr[], int sum) {
        // Base cases
        if(sum == 0)
            return true;
        if(N == 0)
            return false;
        
        // Check if solution already computed
        if(t[N][sum] != null)
            return t[N][sum];
        
        // Choice diagram
        if(arr[N-1] <= sum) {
            t[N][sum] = solve(N-1, arr, sum-arr[N-1]) || solve(N-1, arr, sum);
        } else {
            t[N][sum] = solve(N-1, arr, sum);
        }
        
        return t[N][sum];
    }
}
