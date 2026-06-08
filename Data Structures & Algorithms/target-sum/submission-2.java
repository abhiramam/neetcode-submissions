class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,target,nums,0);
    }
    private int helper(int index,int target,int[] nums,int sum){
        if(index == nums.length){
            return sum == target ? 1 : 0;
        }

        int waysNegative = helper(index+1,target,nums,sum-nums[index]);
        int waysPositive = helper(index+1,target,nums,sum+nums[index]);

        return waysNegative+waysPositive;
    }
}
