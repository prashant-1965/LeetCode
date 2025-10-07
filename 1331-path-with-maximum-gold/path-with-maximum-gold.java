class Solution {
    public static boolean[][] track;
    public int getMaximumGold(int[][] nums) {
        this.track = new boolean[nums.length][nums[0].length];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]!=0){
                    ans = Math.max(ans,dfs(i,j,nums,0));
                }
            }
        }
        return ans;
    }
    public static int dfs(int row, int col, int[][] nums, int sum){
        if(row<0 || col<0 || row==nums.length || col==nums[0].length || nums[row][col]==0 || track[row][col]) return sum;
        track[row][col]=true;
        // int cnt=0;
        int up = dfs(row-1,col,nums,nums[row][col]+sum);
        int down = dfs(row+1,col,nums,nums[row][col]+sum);
        int left = dfs(row,col-1,nums,nums[row][col]+sum);
        int right = dfs(row,col+1,nums,nums[row][col]+sum);
        track[row][col]=false;

        return Math.max(left,Math.max(right,Math.max(up,down)));
    }
}