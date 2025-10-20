class Solution {
    public static List<List<Integer>> ans;
    public static List<Integer> lt;
    public List<List<Integer>> combinationSum2(int[] nums, int k) {
        Arrays.sort(nums);
        this.ans = new ArrayList<>();
        this.lt = new ArrayList<>();
        dfs(0,nums,k);
        return ans;
    }
    public static void dfs(int idx, int[] nums, int k){
        if(k==0){
            ans.add(new ArrayList<>(lt));
            return;
        }
        if(k<0 || idx==nums.length) return;
        lt.add(nums[idx]);
        dfs(idx+1,nums,k-nums[idx]);
        while(idx+1<nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        lt.removeLast();
        dfs(idx+1,nums,k);
    }
}