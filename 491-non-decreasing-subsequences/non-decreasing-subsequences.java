class Solution {
    public List<List<Integer>> ans;
    public Set<List<Integer>> set;
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.ans = new ArrayList<>();
        this.set = new HashSet<>();
        dfs(0,nums,new ArrayList<>(),-101);
        return ans;
    }
    public void dfs(int idx, int[] nums, List<Integer> lt, int parent){
        if(idx==nums.length){
            if(lt.size()>1 && !set.contains(lt)){
                ans.add(new ArrayList<>(lt));
                set.add(new ArrayList<>(lt));
            }
            return;
        }
        if(nums[idx]>=parent){
            lt.add(nums[idx]);
            dfs(idx+1,nums,lt,nums[idx]);
            lt.removeLast();
        }
        dfs(idx+1,nums,lt,parent);
    }
}