class Solution {
    public int longestMountain(int[] nums) {
        int ans=0,low=0;
        for(int i=0;i<nums.length;i++){
            while(i+1<nums.length && nums[i]==nums[i+1])i++;
            if(i+1<nums.length && nums[i]<nums[i+1]){
                low= i;
                while(i+1<nums.length && nums[i]<nums[i+1])i++;
                if(i+1<nums.length && nums[i]==nums[i+1])continue;
                boolean flag = false;
                while(i+1<nums.length && nums[i]>nums[i+1]){
                    i++;
                    flag = true;
                }
                if(!flag)continue;
                if(i+1<nums.length && nums[i]==nums[i+1]){
                    ans = Math.max(ans,i-low+1);
                    continue;
                }
                ans = Math.max(ans,i-low+1);
                i--;
            }
        }
        return ans;
    }
}