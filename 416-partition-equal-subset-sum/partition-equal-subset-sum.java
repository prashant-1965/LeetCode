class Solution {
    public Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)sum+=i;
        if(sum%2==1)return false;
        sum/=2;
        this.dp = new Boolean[nums.length][sum+1];
        return dfs(0,nums,sum);
    }
    public boolean dfs(int idx, int[] nums, int k){
        if(k==0) return true;
        if(idx==nums.length || k<0) return false;
        if(dp[idx][k]!=null) return dp[idx][k];
        return dp[idx][k] = dfs(idx+1,nums,k-nums[idx]) || dfs(idx+1,nums,k);
    }
}