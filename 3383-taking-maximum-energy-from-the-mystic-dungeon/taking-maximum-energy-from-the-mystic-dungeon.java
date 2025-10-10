class Solution {
    public int maximumEnergy(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            dp[nums.length-1-i]=nums[nums.length-1-i];
            ans = Math.max(ans,dp[nums.length-1-i]);
        }
        for(int i=nums.length-1-k;i>=0;i--){
            dp[i] = nums[i]+dp[i+k];
            ans = Math.max(ans,dp[i]);
        }
        return ans;
        
    }
}