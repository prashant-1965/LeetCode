class Solution {
    public static boolean[][] track;
    public void solve(char[][] nums) {
        this.track= new boolean[nums.length][nums[0].length];
        for(int i=1;i<nums.length-1;i++){
            for(int j=1;j<nums[0].length-1;j++){
                if(nums[i][j]=='O'){
                    boolean[][] path = new boolean[nums.length][nums[0].length];
                    if(dfs(i,j,nums,path)){
                        for(int k=0;k<path.length;k++){
                            for(int l=0;l<path[0].length;l++){
                                if(path[k][l])nums[k][l]='X';
                            }
                        }
                    }
                }
            }
        }
    }
    public static boolean dfs(int row, int col, char[][] nums, boolean[][] path){
        if(row<0 || col <0 || row==nums.length || col==nums[0].length) return false;
        if(nums[row][col]=='X' || track[row][col]) return true;
        track[row][col]=true;
        path[row][col]=true;
        boolean top = dfs(row-1,col,nums,path);
        boolean down = dfs(row+1,col,nums,path);
        boolean left = dfs(row,col-1,nums,path);
        boolean right = dfs(row,col+1,nums,path);
        return top && down && left && right;
        
    }
}