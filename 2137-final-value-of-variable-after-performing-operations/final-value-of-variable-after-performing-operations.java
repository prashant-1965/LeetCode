class Solution {
    public int finalValueAfterOperations(String[] nums) {
        int ans=0;
        for(String i:nums){
            if(i.charAt(1)=='+')ans++;
            else ans--;
        }
        return ans;
    }
}