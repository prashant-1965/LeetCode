class Solution {
    public int[][] rangeAddQueries(int n, int[][] nums) {
        int[][] ans = new int[n][n];
        for(int i=0;i<nums.length;i++){
            for(int j=nums[i][0];j<=nums[i][2];j++){
                for(int k=nums[i][1];k<=nums[i][3];k++){
                    ans[j][k]+=1;
                }
            }
        }
        return ans;
    }
}