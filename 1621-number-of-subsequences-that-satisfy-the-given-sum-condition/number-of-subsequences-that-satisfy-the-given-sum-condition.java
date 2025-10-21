class Solution {
    public int numSubseq(int[] nums, int k) {
        Arrays.sort(nums);
        long[] power = new long[nums.length];
        power[0]=1L;
        for(int i=1;i<power.length;i++){
            power[i]= (int)(2L*power[i-1])%1000000007;
        }
        int low=0,high=nums.length-1,ans=0;
        while(low<=high){
            if(nums[low]+nums[high]>k){
                high--;
            }else{
                int digit = (high-low);
                long val = (power[digit]+ans)%1000000007;
                ans = (int)val;
                low++;
            }
        }
        
        return ans;
    }
}