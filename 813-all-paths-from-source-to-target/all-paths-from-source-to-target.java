class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] nums) {
        boolean[] track = new boolean[nums.length];
        ans = new ArrayList<>();
        dfs(0,new ArrayList<>(),nums,track);
        return ans;
    }
    public static void dfs(int n, List<Integer> lt, int[][] nums, boolean[] track){
        if(n==nums.length-1 || (nums[n].length==0 && n==nums.length-1)){
            lt.add(n);
            ans.add(new ArrayList<>(lt));
            lt.remove(lt.size()-1);
            return;
        }
        if(track[n]) return;
        track[n]=true;
        lt.add(n);
        for(int i=0;i<nums[n].length;i++){
            dfs(nums[n][i],lt,nums,track);
        }
        lt.remove(lt.size()-1);
        track[n]=false;
    }
}