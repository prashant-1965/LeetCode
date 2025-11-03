class Solution {
    public int minCost(String s, int[] nums) {
        int[] mono= new int[nums.length];
        int[] max = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            mono[i] = nums[i]; max[i] = nums[i];
            while(i+1<nums.length && s.charAt(i)==s.charAt(i+1)){
                mono[i+1] = nums[i+1]+mono[i];
                max[i+1] = Math.max(nums[i+1],max[i]);
                i++;
            }
        }
        boolean flag = false;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            flag = false;
            while(i+1<nums.length && s.charAt(i)==s.charAt(i+1)){
                i++;
                flag = true;
            }
            if(flag)ans+=(mono[i]-max[i]);
        }
        return ans;
    }
}