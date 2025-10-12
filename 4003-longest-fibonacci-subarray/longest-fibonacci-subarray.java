class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length==1 || nums.length==2) return nums.length;
        int low=0,ans=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i-1]+nums[i-2]!=nums[i]){
                low=i-1;
            }
            ans= Math.max(ans,i-low+1);
        }
        return ans;
    }
}