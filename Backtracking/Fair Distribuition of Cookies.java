class Solution {
    public int distributeCookies(int[] arr, int k) {
        int n=arr.length;
        int[] std=new int[n];
        return helper(arr, 0, k,std);
        //simple backtracking solution draw reurisve tree for eg [5,10,4] , k=2;
        // keep an array which will store the current candies each student has which will have length of k.

    }
    int helper(int[] arr, int index, int k, int[] std){
        //once all cookies distributed get the max of the stduent and return it
        if(index==arr.length){
            int max=0;
            for(int x:std){
                if(x>max)max=x;
            }
            return max;
        }

        int res=Integer.MAX_VALUE;

        for(int kIdx=0;kIdx<k;kIdx++){ //for the current cookie, try to distribute it to each student one by one and see which gets us minimum unfairness
            std[kIdx]=std[kIdx]+arr[index]; //distribute inndex candy to kIdx student
            res=Math.min(res, helper(arr, index+1, k, std)); //go for next candy, and get min of when you distributed candy to kidx, as compared to kidx+1 and so on
            std[kIdx]=std[kIdx]-arr[index];  //now backtrack the given candy since we are working on array, it need to be removed as the array will share same memorey object.
            if(std[kIdx] == 0){break;} //if 
        }
return res;
    }
}
