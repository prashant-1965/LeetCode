class Solution {
    public static boolean[][] track;
    public static char[][] nums;
    public static boolean flag;
    public boolean containsCycle(char[][] nums) {
        this.track = new boolean[nums.length][nums[0].length];
        this.nums = nums;
        this.flag = false;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(!track[i][j]){
                    dfs(i,j,nums[i][j],0);
                    if(flag) return flag;
                }
            }
        }
        return flag;
    }
    public static void dfs(int row, int col, char parent, int prev){
        if(row<0 || row==nums.length || col<0 || col==nums[0].length || nums[row][col]!=parent || flag) return;
        if(track[row][col]){
            flag = true;
            return;
        }
        track[row][col] = true;
        if(prev==0){
            dfs(row,col+1,nums[row][col],0);
            dfs(row+1,col,nums[row][col],1);
            dfs(row-1,col,nums[row][col],3);
        }else if(prev==1){
            dfs(row,col+1,nums[row][col],0);
            dfs(row+1,col,nums[row][col],1);
            dfs(row,col-1,nums[row][col],2);
        }else if(prev==2){
            dfs(row+1,col,nums[row][col],1);
            dfs(row,col-1,nums[row][col],2);
            dfs(row-1,col,nums[row][col],3);
        }else{
            dfs(row,col+1,nums[row][col],0);
            dfs(row,col-1,nums[row][col],2);
            dfs(row-1,col,nums[row][col],3);
        }
    }
}