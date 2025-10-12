class Solution {
    public static Integer[][] dp;
    public int longestIncreasingPath(int[][] nums) {
        int ans=0;
        this.dp = new Integer[nums.length][nums[0].length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                ans = Math.max(ans,dfs(i,j,-1,new boolean[nums.length][nums[0].length],nums));
            }
        }
        return ans;
    }
    public static int dfs(int row, int col, int parent, boolean[][] track, int[][] nums){
        if(row<0 || col<0 || row==nums.length || col==nums[0].length || track[row][col] || nums[row][col]<=parent) return 0;
        if(dp[row][col]!=null) return dp[row][col];
        track[row][col]=true;
        int up = dfs(row-1,col,nums[row][col],track,nums);
        int down = dfs(row+1,col,nums[row][col],track,nums);
        int left = dfs(row,col-1,nums[row][col],track,nums);
        int right = dfs(row,col+1,nums[row][col],track,nums);
        track[row][col]=false;
        return dp[row][col]= 1+Math.max(up,Math.max(down,Math.max(left,right)));
    }
}