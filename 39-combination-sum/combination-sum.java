class Solution {
    public List<List<Integer>> ans;
    public List<Integer> lt;
    public List<List<Integer>> combinationSum(int[] nums, int k) {
        this.ans = new ArrayList<>();
        this.lt = new ArrayList<>();
        dfs(0,nums,k);
        return ans;
    }
    public void dfs(int idx, int[] nums, int k){
        if(k==0){
            ans.add(new ArrayList<>(lt)); return;
        }
        if(k<0 || idx==nums.length) return;
        lt.add(nums[idx]);
        dfs(idx,nums,k-nums[idx]);
        lt.removeLast();
        dfs(idx+1,nums,k);
    }
}