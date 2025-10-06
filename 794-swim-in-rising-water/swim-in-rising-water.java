class Solution {
    public int swimInWater(int[][] nums) {
        int ans = -1;
        int low=0,high=nums[0].length*nums.length;
        while(low<=high){
            int mid = (low+high)/2;
            boolean reach = dfs(0,0,mid,nums,new boolean[nums.length][nums[0].length]);
            if(reach){
                ans=mid;
                high=  mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean dfs(int row, int col, int k, int[][] nums, boolean[][] track){
        if(row<0 || col<0 || row==nums.length || col==nums[0].length || track[row][col] || nums[row][col]>k) return false;
        if(col==nums.length-1 && row==nums[0].length-1) return true;
        track[row][col]=true;
        boolean top = dfs(row-1,col,k,nums,track);
        boolean down = dfs(row+1,col,k,nums,track);
        boolean left = dfs(row,col-1,k,nums,track);
        boolean right = dfs(row,col+1,k,nums,track);
        return (top || down || left || right);
    }
}