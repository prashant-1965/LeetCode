class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] nums) {
        ans = new ArrayList<>();
        dfs(0,new ArrayList<>(),nums);
        return ans;
    }
    public static void dfs(int n, List<Integer> lt, int[][] nums){
        if(n==nums.length-1 || (nums[n].length==0 && n==nums.length-1)){
            lt.add(n);
            ans.add(new ArrayList<>(lt));
            lt.remove(lt.size()-1);
            return;
        }
        lt.add(n);
        for(int i=0;i<nums[n].length;i++){
            dfs(nums[n][i],lt,nums);
        }
        lt.remove(lt.size()-1);
    }
}