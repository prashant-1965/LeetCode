class Solution {
    public static boolean[][] track;
    public static char[][] nums;
    public int numIslands(char[][] nums) {
        this.nums = nums;
        track = new boolean[nums.length][nums[0].length];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]=='1' && !track[i][j]){
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        return cnt;
    }
    public static void dfs(int i, int j){
        if(i<0 || j<0 || i==nums.length || j==nums[0].length || nums[i][j]=='0') return;
        if(nums[i][j]=='1' && !track[i][j]){
            track[i][j]= true;
            dfs(i,j+1);
            dfs(i+1,j);
            dfs(i,j-1);
            dfs(i-1,j);
        }
    }
}