/******* Intuition*********/
/* 
We will first calculate the total sum of array. If the total sum is odd then its impossible to make 2 subsets with equal sum. Suppose if array is {1,5,6 11}
The total sum of array is 23. we cannot divide this array in two equal sum subset, Hence returning false. If the totalSum is even then we can find sum of one subset by
dividing it into 2 halves. Then we will find a subset whose sum is totalSum/2 (Like Subset Sum problem).
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int num : nums) {
            totalSum += num; // calculating total sum
        }
        if (totalSum % 2 != 0)
            return false;  //if total sum is odd then return false no need to check further
        int sum = totalSum / 2;
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true; // here i am filling 1st column with true as seen in DP Table
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j)
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }
}
