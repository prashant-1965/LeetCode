class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int low;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                low=i;
                i++;
                while(i<nums.length && nums[i]==0){
                    i++;
                }
                if(i!=nums.length && i-low-1<k) return false;
                i--;
            }
        }
        return true;
    }
}