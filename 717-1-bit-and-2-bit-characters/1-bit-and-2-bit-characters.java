class Solution {
    public boolean isOneBitCharacter(int[] nums) {
        int i=0;
        boolean ans=false;
        while(i<nums.length){
            if(nums[i]==0){
                ans =true;
                i++;
            }else if(nums[i]==1 && i+1<nums.length){
                i+=2;
                ans = false;
            }
        }
        return ans;
    }
}