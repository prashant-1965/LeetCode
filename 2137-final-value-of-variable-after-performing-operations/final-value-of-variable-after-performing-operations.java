class Solution {
    public int finalValueAfterOperations(String[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(1)=='+')ans++;
            else ans--;
        }
        return ans;
    }
}