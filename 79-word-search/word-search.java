class Solution {
    public static boolean[][] track;
    public boolean exist(char[][] nums, String s) {
        this.track = new boolean[nums.length][nums[0].length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==s.charAt(0)){
                    if(dfs(i,j,0,nums,s)) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int row, int col, int idx, char[][] nums, String s){
        if(idx==s.length()) return true;
        if(row<0 || col<0 || row==nums.length || col==nums[0].length || nums[row][col]!=s.charAt(idx) || track[row][col]) return false;
        track[row][col]=true;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean flag = false;
        for(int i=0;i<4;i++){
            int r = dir[i][0]; int c = dir[i][1];
            flag |= dfs(row+r,col+c,idx+1,nums,s);
        }
        track[row][col]=false;
        return flag;
    }
}