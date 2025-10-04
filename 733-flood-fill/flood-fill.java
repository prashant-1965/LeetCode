class Solution {
    public static int[][] nums;
    public static boolean[][] track;
    public static int val;
    public int[][] floodFill(int[][] nums, int row, int col, int k) {
        this.nums = nums;
        track = new boolean[nums.length][nums[0].length];
        val = nums[row][col];
        dfs(row,col,k);
        return nums;
    }
    public static void dfs(int row, int col, int k){
        if(row<0 || col<0 || row==nums.length || col==nums[0].length || track[row][col] || nums[row][col]!=val) return;
        track[row][col] = true;
        nums[row][col] = k;
        dfs(row+1,col,k);
        dfs(row,col+1,k);
        dfs(row-1,col,k);
        dfs(row,col-1,k);
    }
}