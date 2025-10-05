class Solution {
    public int orangesRotting(int[][] nums) {

        int cnt=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==1)cnt++;
            }
        }
        if(cnt==0) return 0;

        int loop=0,total =nums[0].length*nums.length;
        boolean[][] track;

        while(total-->0){
            track = new boolean[nums.length][nums[0].length];
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<nums[0].length;j++){
                    if(nums[i][j]==2 && !track[i][j]){
                        if(i-1>=0 && nums[i-1][j]==1){
                            nums[i-1][j]=2; track[i-1][j]=true; cnt--;
                        }
                        if(i+1<nums.length && nums[i+1][j]==1){
                            nums[i+1][j]=2; track[i+1][j]=true; cnt--;
                        }
                        if(j-1>=0 && nums[i][j-1]==1){
                            nums[i][j-1]=2; track[i][j-1]=true; cnt--;
                        }
                        if(j+1<nums[0].length && nums[i][j+1]==1){
                            nums[i][j+1]=2; track[i][j+1]=true; cnt--;
                        }
                        track[i][j]=true;
                    }
                }
            }
            loop++;
            if(cnt==0) return loop;
        }
        return -1;
    }
}