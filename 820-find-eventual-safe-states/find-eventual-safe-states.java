class Solution {
    public static boolean[] track;
    public static Boolean[] dp;
    public List<Integer> eventualSafeNodes(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        this.track = new boolean[nums.length];
        this.dp = new Boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(!dfs(i,-1,nums)){
                ans.add(i);
            }
        }
        return ans;
    }
    public static boolean dfs(int n, int parent, int[][] nums){
        // if(track[n] && n==parent) return false;
        if(dp[n]!=null) return dp[n];
        if(track[n]) return true;
        track[n]=true;
        boolean flag = false;
        for(int i=0;i<nums[n].length;i++){
            int val = nums[n][i];
            flag |= dfs(val,n,nums);
        }
        track[n]=false;
        return dp[n] = flag;
    }
}