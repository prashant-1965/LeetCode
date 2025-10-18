class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int last = Integer.MIN_VALUE; 
        
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i] - k;
            int end = nums[i] + k;
            int val = Math.max(last + 1, start);
            
            if (val <= end) {
                cnt++;
                last = val;
            }
        }
        return cnt;
    }
}
