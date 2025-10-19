class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        this.ans = new ArrayList<>();
        dfs(0,nums,new ArrayList<>());
        return ans;
    }
    public static void dfs(int idx, int[] nums, List<Integer> lt){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(lt)); return;
        }
        lt.add(nums[idx]);
        dfs(idx+1,nums,lt);
        lt.remove(lt.get(lt.size()-1));
        dfs(idx+1,nums,lt);
    }
}