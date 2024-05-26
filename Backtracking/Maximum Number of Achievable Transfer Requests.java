class Solution {
    int result =0;
    int m;
    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;
        int arr[] = new int[n];
        Arrays.fill(arr,0);
        solve(0,0,n,arr,requests);
        return result;
    }

    private void solve(int idx, int count, int n, int[] arr, int[][]requests)
    {
        if(idx == m)
        {
            boolean zero = true;
            for(int nums: arr)
            {
                if (nums != 0){
                zero = false;
                break;
                }
            }
            if(zero == true)
            {
                result = Math.max(result,count);
            }
            return;
        }

        int from = requests[idx][0];
        int to = requests[idx][1];
        arr[from]--;
        arr[to]++;
        solve(idx+1,count+1,n,arr,requests);
        arr[from]++;
        arr[to]--;
        solve(idx+1,count,n,arr,requests);
    }
}
