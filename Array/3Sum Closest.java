class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = 100000;
        if(n==3)
        return nums[0]+nums[1]+nums[2];
        for(int k=0;k<n-2;k++)
        {
            int i=k+1;
            int j=n-1;
            while(i<j)
            {
                int sum = nums[k] + nums[i]+ nums[j];
                if(Math.abs(sum-target) < Math.abs(target-closestSum))
                closestSum = sum;
                if(sum >target)
                j--;
                else
                i++;

            }
        }
        return closestSum;
    }
}
