class Solution {
    public static boolean[][] track;
    public static int cnt;
    public int numEnclaves(int[][] nums) {
        this.track = new boolean[nums.length][nums[0].length];
        int ans=0;
        for(int i=1;i<nums.length-1;i++){
            for(int j=1;j<nums[0].length-1;j++){
                if(!track[i][j] && nums[i][j]==1){
                    this.cnt=0;
                    if(dfs(i,j,nums)){
                        ans+=cnt;
                    }
                }
            }
        }
        return ans;
    }
    public static boolean dfs(int row, int col, int[][] nums){
        if(row<0 || col<0 || row==nums.length || col==nums[0].length || nums[row][col]==0 || track[row][col]) return true;
        if(nums[row][col]==1 && (row==nums.length-1 || col==nums[0].length-1 || row==0 || col==0)) return false;
        track[row][col]=true;
        cnt++;
        boolean up = dfs(row-1, col, nums);
        boolean down = dfs(row+1, col, nums);
        boolean left = dfs(row, col-1, nums);
        boolean right = dfs(row, col+1, nums);

        return up && down && left && right;
    }
}

